package com.company.lms.services.impl;

import com.company.lms.db.CustomerKYC;
import com.company.lms.db.repos.KYCRepository;
import com.company.lms.exceptions.GenericException;
import com.company.lms.model.res.GenericResponse;
import com.company.lms.model.soap.Customer;
import com.company.lms.model.soap.Transactions;
import com.company.lms.model.soap.TransactionsMod;
import com.company.lms.model.soap.TransactionsResponse;
import com.company.lms.services.SoapRequestService;
import com.company.lms.utilis.AppConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class SoapRequestImpl implements SoapRequestService {
    @Value("${app.soap.username}"
    )
    private String soapUsername;
    @Value("${app.soap.password}"
    )
    private String soapPassword;
    private final KYCRepository kycRepository;
    @SneakyThrows
    public Mono<String> makeRequest(String data, String url) {
        return Mono.fromCallable(()->callSoapService(data,url))
                .onErrorResume(error ->{
                    log.info("Error: {}",error);
                return Mono.error(new GenericException("An error occurred when fetching data from core banking."));
                }
                );
    }

    public  <T> T getJavaObjectFromSoapXml(String response, Class<T> clazz) {
        try {
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(response));
            xsr.nextTag();
            while (!xsr.getLocalName().equalsIgnoreCase(clazz.getSimpleName())) {
                xsr.nextTag();
                log.info("TAG :{}",xsr.getLocalName());
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new StAXSource(xsr), new StreamResult(stringWriter));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(new StringReader(stringWriter.toString())));
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(document);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static String callSoapService(String soapRequest, String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(soapRequest);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            System.out.println(responseStatus);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String finalvalue = response.toString();


            return finalvalue;
        } catch (Exception e) {
            return e.getMessage();

        }
    }

    @Override
    public Mono<GenericResponse> fetchKYC(String customerNumber) {
        String data = String.format(AppConstants.KYC_REQUEST,soapUsername, soapPassword,customerNumber);

        return kycRepository.findByCustomerNumber(customerNumber).map(customerKYC -> {

            log.info("FOUND IN DB");
                   return new Gson().fromJson(new Gson().toJson(customerKYC), Customer.class);
                })
                .switchIfEmpty( makeRequest(data, AppConstants.KYC_URL)
                        .map(result->
                        {
                            log.info("RES: {}",result);
                            return getJavaObjectFromSoapXml(result,Customer.class);
                        })
                        .subscribeOn(Schedulers.boundedElastic())
                        .map(result->
                        {
                            try {
                                log.info("SAVING TO DB");
                                var s =kycRepository.save(new Gson().fromJson(new Gson().toJson(result), CustomerKYC.class));

                                log.info(s.toString());
                            }catch (Exception e)
                            {
                                e.printStackTrace();
//                                throw Exceptions.propagate(e);
                            }

                            return result;
                        })
                .onErrorResume(error->{
                    log.info("We were unable to find KYC for this customer");
                    throw new GenericException("We were not able to find this customer details.");
                })).map(s-> new GenericResponse<>("STATUS", s));
    }


    @Override
    public Flux<TransactionsMod> fetchTransactionsHistory(String customerNumber) {
        String data = String.format(AppConstants.TRANSACTIONS_REQ,soapUsername, soapPassword,customerNumber);
        return makeRequest(data, AppConstants.TRANSACTIONS_URL)
                .log()
                .map(result->
                {
                    log.info("RES: {}",result);
                    return getJavaObjectFromSoapXml(result,TransactionsResponse.class);
//                }).map(TransactionsResponse::getTransactions).flatMapMany(Flux::fromIterable)
                }).map(tr->convert(tr.getTransactions())).flatMapMany(Flux::fromIterable)
                .subscribeOn(Schedulers.boundedElastic())
                .onErrorResume(error->{
                    log.info("We were unable to find KYC for this customer");
                    throw new GenericException("We were not able to find this customer details.");
                });
    }
    @SneakyThrows
    private List<TransactionsMod> convert(List<Transactions> transactions)
    {
        List<TransactionsMod> transactionsMods = new LinkedList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ObjectWriter objectWriter = objectMapper.writer().withoutAttribute("createdAt").withoutAttribute("createdDate").withoutAttribute("updatedAt").withoutAttribute("lastTransactionDate");

        transactions.parallelStream().forEach(transaction->
        {
            String s;
            try {
                log.info("Raw: {}",transaction);
                s = objectWriter.writeValueAsString(transaction);
                TransactionsMod res = objectMapper.readValue(s, TransactionsMod.class);
//                res.setCreatedAt(transaction.getCreatedAt().getTime());
                res.setCreatedDate(transaction.getCreatedDate().getTime());
                res.setLastTransactionDate(transaction.getLastTransactionDate().getTime());
                res.setUpdatedAt(transaction.getUpdatedAt().getTime());
                log.info("Converted: {}",res);
                transactionsMods.add(res);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }


        });
        return transactionsMods;

    }
}
