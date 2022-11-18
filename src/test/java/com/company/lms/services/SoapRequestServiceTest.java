package com.company.lms.services;

import com.company.lms.model.soap.Customer;
import com.company.lms.model.soap.TransactionsResponse;
import com.company.lms.services.impl.SoapRequestImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SoapRequestServiceTest {
    @Autowired
    SoapRequestImpl soapRequestService;

    @Test
    void makeCustomerRequest() {
        String url = "https://kycapitest.credable.io/service/customerWsdl.wsdl";
        String data = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cus=\"http://credable.io/cbs/customer\">\n" +
                "   <soapenv:Header>\n" +
                "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" wsse:mustUnderstand=\"1\">\n" +
                "  <wsse:UsernameToken>\n" +
                "     <wsse:Username>admin</wsse:Username>\n" +
                "     <wsse:Password>pwd123</wsse:Password>\n" +
                "  </wsse:UsernameToken>\n" +
                "</wsse:Security>\n" +
                "   </soapenv:Header>\n" +
                "   <soapenv:Body>\n" +
                "      <cus:CustomerRequest>\n" +
                "         <cus:customerNumber>234774784</cus:customerNumber>\n" +
                "      </cus:CustomerRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        var res= soapRequestService.makeRequest(data, url);
        System.out.println(res);
        assertNotEquals(res, null);

    }
    @Test
    void conVertCustomerWorks()
    {
        String res="<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <SOAP-ENV:Header/>\n" +
                "   <SOAP-ENV:Body>\n" +
                "      <ns2:CustomerResponse xmlns:ns2=\"http://credable.io/cbs/customer\">\n" +
                "         <ns2:customer>\n" +
                "            <ns2:createdAt>1980-02-25T02:59:03.000+03:00</ns2:createdAt>\n" +
                "            <ns2:createdDate>2019-05-23T23:27:19.000+03:00</ns2:createdDate>\n" +
                "            <ns2:customerNumber>234774784</ns2:customerNumber>\n" +
                "            <ns2:email>nola54@example.com</ns2:email>\n" +
                "            <ns2:firstName>Thad</ns2:firstName>\n" +
                "            <ns2:gender>MALE</ns2:gender>\n" +
                "            <ns2:id>1</ns2:id>\n" +
                "            <ns2:idNumber>4019</ns2:idNumber>\n" +
                "            <ns2:idType>NATIONAL_ID</ns2:idType>\n" +
                "            <ns2:lastName>Windler</ns2:lastName>\n" +
                "            <ns2:middleName>velit</ns2:middleName>\n" +
                "            <ns2:mobile>+66(0)0595876293</ns2:mobile>\n" +
                "            <ns2:monthlyIncome>69.0</ns2:monthlyIncome>\n" +
                "            <ns2:status>ACTIVE</ns2:status>\n" +
                "            <ns2:updatedAt>2020-11-13T17:28:13.000+03:00</ns2:updatedAt>\n" +
                "         </ns2:customer>\n" +
                "      </ns2:CustomerResponse>\n" +
                "   </SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";
        var resObj = soapRequestService.getJavaObjectFromSoapXml(res, Customer.class);
        System.out.println(resObj);
        assertNotEquals(resObj, null);
    }
    @Test
    void convertTransactionWorks()
    {
        String res= "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <SOAP-ENV:Header/>\n" +
                "   <SOAP-ENV:Body>\n" +
                "      <ns2:TransactionsResponse xmlns:ns2=\"http://credable.io/cbs/transaction\">\n" +
                "         <ns2:transactions>\n" +
                "            <ns2:accountNumber>332216783322167555621628</ns2:accountNumber>\n" +
                "            <ns2:alternativechanneltrnscrAmount>87988.2441</ns2:alternativechanneltrnscrAmount>\n" +
                "            <ns2:alternativechanneltrnscrNumber>0</ns2:alternativechanneltrnscrNumber>\n" +
                "            <ns2:alternativechanneltrnsdebitAmount>675.3423</ns2:alternativechanneltrnsdebitAmount>\n" +
                "            <ns2:alternativechanneltrnsdebitNumber>902403930</ns2:alternativechanneltrnsdebitNumber>\n" +
                "            <ns2:atmTransactionsNumber>4812921</ns2:atmTransactionsNumber>\n" +
                "            <ns2:atmtransactionsAmount>561.96661249</ns2:atmtransactionsAmount>\n" +
                "            <ns2:bouncedChequesDebitNumber>8</ns2:bouncedChequesDebitNumber>\n" +
                "            <ns2:bouncedchequescreditNumber>0</ns2:bouncedchequescreditNumber>\n" +
                "            <ns2:bouncedchequetransactionscrAmount>748011.19</ns2:bouncedchequetransactionscrAmount>\n" +
                "            <ns2:bouncedchequetransactionsdrAmount>43345.569028578</ns2:bouncedchequetransactionsdrAmount>\n" +
                "            <ns2:chequeDebitTransactionsAmount>4.6933076819151E8</ns2:chequeDebitTransactionsAmount>\n" +
                "            <ns2:chequeDebitTransactionsNumber>44</ns2:chequeDebitTransactionsNumber>\n" +
                "            <ns2:createdAt>1993-06-16T21:12:12.000+03:00</ns2:createdAt>\n" +
                "            <ns2:createdDate>2007-11-28T22:10:16.000+03:00</ns2:createdDate>\n" +
                "            <ns2:credittransactionsAmount>609.297663</ns2:credittransactionsAmount>\n" +
                "            <ns2:debitcardpostransactionsAmount>21.134264</ns2:debitcardpostransactionsAmount>\n" +
                "            <ns2:debitcardpostransactionsNumber>502</ns2:debitcardpostransactionsNumber>\n" +
                "            <ns2:fincominglocaltransactioncrAmount>0.0</ns2:fincominglocaltransactioncrAmount>\n" +
                "            <ns2:id>2</ns2:id>\n" +
                "            <ns2:incominginternationaltrncrAmount>70.52733936</ns2:incominginternationaltrncrAmount>\n" +
                "            <ns2:incominginternationaltrncrNumber>9</ns2:incominginternationaltrncrNumber>\n" +
                "            <ns2:incominglocaltransactioncrNumber>876</ns2:incominglocaltransactioncrNumber>\n" +
                "            <ns2:intrestAmount>310118</ns2:intrestAmount>\n" +
                "            <ns2:lastTransactionDate>2007-01-21T06:30:29.000+03:00</ns2:lastTransactionDate>\n" +
                "            <ns2:lastTransactionValue>3</ns2:lastTransactionValue>\n" +
                "            <ns2:maxAtmTransactions>6.0</ns2:maxAtmTransactions>\n" +
                "            <ns2:maxMonthlyBebitTransactions>5.66201073E8</ns2:maxMonthlyBebitTransactions>\n" +
                "            <ns2:maxalternativechanneltrnscr>0.0</ns2:maxalternativechanneltrnscr>\n" +
                "            <ns2:maxalternativechanneltrnsdebit>0.0</ns2:maxalternativechanneltrnsdebit>\n" +
                "            <ns2:maxbouncedchequetransactionscr>0.0</ns2:maxbouncedchequetransactionscr>\n" +
                "            <ns2:maxchequedebittransactions>0.0</ns2:maxchequedebittransactions>\n" +
                "            <ns2:maxdebitcardpostransactions>5.18696078798654E15</ns2:maxdebitcardpostransactions>\n" +
                "            <ns2:maxincominginternationaltrncr>0.0</ns2:maxincominginternationaltrncr>\n" +
                "            <ns2:maxincominglocaltransactioncr>0.0</ns2:maxincominglocaltransactioncr>\n" +
                "            <ns2:maxmobilemoneycredittrn>0.0</ns2:maxmobilemoneycredittrn>\n" +
                "            <ns2:maxmobilemoneydebittransaction>0.0</ns2:maxmobilemoneydebittransaction>\n" +
                "            <ns2:maxmonthlycredittransactions>0.0</ns2:maxmonthlycredittransactions>\n" +
                "            <ns2:maxoutgoinginttrndebit>0.0</ns2:maxoutgoinginttrndebit>\n" +
                "            <ns2:maxoutgoinglocaltrndebit>0.0</ns2:maxoutgoinglocaltrndebit>\n" +
                "            <ns2:maxoverthecounterwithdrawals>959858.0</ns2:maxoverthecounterwithdrawals>\n" +
                "            <ns2:minAtmTransactions>0.0</ns2:minAtmTransactions>\n" +
                "            <ns2:minMonthlyDebitTransactions>0.0</ns2:minMonthlyDebitTransactions>\n" +
                "            <ns2:minalternativechanneltrnscr>0.0</ns2:minalternativechanneltrnscr>\n" +
                "            <ns2:minalternativechanneltrnsdebit>0.0</ns2:minalternativechanneltrnsdebit>\n" +
                "            <ns2:minbouncedchequetransactionscr>0.0</ns2:minbouncedchequetransactionscr>\n" +
                "            <ns2:minchequedebittransactions>0.0</ns2:minchequedebittransactions>\n" +
                "            <ns2:mindebitcardpostransactions>4.539102239610779E15</ns2:mindebitcardpostransactions>\n" +
                "            <ns2:minincominginternationaltrncr>0.0</ns2:minincominginternationaltrncr>\n" +
                "            <ns2:minincominglocaltransactioncr>0.0</ns2:minincominglocaltransactioncr>\n" +
                "            <ns2:minmobilemoneycredittrn>0.0</ns2:minmobilemoneycredittrn>\n" +
                "            <ns2:minmobilemoneydebittransaction>524.0</ns2:minmobilemoneydebittransaction>\n" +
                "            <ns2:minmonthlycredittransactions>0.0</ns2:minmonthlycredittransactions>\n" +
                "            <ns2:minoutgoinginttrndebit>0.0</ns2:minoutgoinginttrndebit>\n" +
                "            <ns2:minoutgoinglocaltrndebit>0.0</ns2:minoutgoinglocaltrndebit>\n" +
                "            <ns2:minoverthecounterwithdrawals>5821338.0</ns2:minoverthecounterwithdrawals>\n" +
                "            <ns2:mobilemoneycredittransactionAmount>0.0</ns2:mobilemoneycredittransactionAmount>\n" +
                "            <ns2:mobilemoneycredittransactionNumber>946843</ns2:mobilemoneycredittransactionNumber>\n" +
                "            <ns2:mobilemoneydebittransactionAmount>0.0</ns2:mobilemoneydebittransactionAmount>\n" +
                "            <ns2:mobilemoneydebittransactionNumber>5523407</ns2:mobilemoneydebittransactionNumber>\n" +
                "            <ns2:monthlyBalance>6.59722841E8</ns2:monthlyBalance>\n" +
                "            <ns2:monthlydebittransactionsAmount>103262.90429936</ns2:monthlydebittransactionsAmount>\n" +
                "            <ns2:outgoinginttransactiondebitAmount>5.473303560725E7</ns2:outgoinginttransactiondebitAmount>\n" +
                "            <ns2:outgoinginttrndebitNumber>646</ns2:outgoinginttrndebitNumber>\n" +
                "            <ns2:outgoinglocaltransactiondebitAmount>565972.1236</ns2:outgoinglocaltransactiondebitAmount>\n" +
                "            <ns2:outgoinglocaltransactiondebitNumber>2971</ns2:outgoinglocaltransactiondebitNumber>\n" +
                "            <ns2:overdraftLimit>0.0</ns2:overdraftLimit>\n" +
                "            <ns2:overthecounterwithdrawalsAmount>332.0</ns2:overthecounterwithdrawalsAmount>\n" +
                "            <ns2:overthecounterwithdrawalsNumber>87569</ns2:overthecounterwithdrawalsNumber>\n" +
                "            <ns2:transactionValue>1.0</ns2:transactionValue>\n" +
                "            <ns2:updatedAt>1994-07-07T10:47:10.000+03:00</ns2:updatedAt>\n" +
                "         </ns2:transactions>"+
                "      </ns2:TransactionsResponse>\n" +
                "   </SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";

//        var resObj = soapRequestService.getJavaObjectFromSoapXml(res, TransactionsResponse.class);
//        System.out.println(resObj);
//        assertNotEquals(resObj, null);

    }
}