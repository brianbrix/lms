package com.company.lms.services.impl;

import com.company.lms.db.LoanRequestEntity;
import com.company.lms.db.repos.LoanRequestRepository;
import com.company.lms.exceptions.GenericException;
import com.company.lms.model.req.ClientRequest;
import com.company.lms.model.req.LoanRequest;
import com.company.lms.model.res.ClientResponse;
import com.company.lms.model.res.GenericResponse;
import com.company.lms.model.res.ScoreInitResponse;
import com.company.lms.model.res.ScoreResponse;
import com.company.lms.services.LoanService;
import com.company.lms.utilis.AppConstants;
import com.company.lms.utilis.GenericWebclient;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class LoanServiceImpl implements LoanService {
    private final LoanRequestRepository loanRequestRepository;

    @Override
    public Mono<GenericResponse<LoanRequestEntity>> requestLoan(LoanRequest loanRequest) {
        loanRequest.setStatus("NEW");
        return loanRequestRepository.findByCustomerNumberAndStatus(loanRequest.getCustomerNumber(), List.of("NEW", "PENDING"))
                .flatMap(res -> Mono.just(new GenericResponse<>("FAILED", "There is an already existing  loan request", res)))
                .switchIfEmpty(Mono.defer(()->loanRequestRepository.save(new Gson().fromJson(new Gson().toJson(loanRequest), LoanRequestEntity.class))
                        .map(request -> new GenericResponse<>("SUCCESS", "SUCCESS", request))));
    }

    @Override
    public Mono<GenericResponse<LoanRequestEntity>> requestLoanStatus(Long loanId) {
        return loanRequestRepository.findById(loanId)
                .flatMap(res -> Mono.just(new GenericResponse<>("SUCCESS", "", res)))
                .switchIfEmpty(Mono.defer(()-> Mono.just(new GenericResponse<>("FAILED", "SUCCESS",null))));
    }
    @SneakyThrows
    @Override
    public Mono<ScoreInitResponse> initScoreRequest(String customerNumber, String headerToken)
    {
        return GenericWebclient.getForSingleObjResponse(String.format(AppConstants.SCORE_INIT_URL, customerNumber), String.class, headerToken)
                .map(res->ScoreInitResponse.builder().token(res).build());
    }
    @SneakyThrows
    @Override
    public Mono<ScoreResponse> getScore(String token, String headerToken)
    {
        return GenericWebclient.getForSingleObjResponseWithExponentialRetries(String.format(AppConstants.SCORE_URL, token), ScoreResponse.class, headerToken);

    }

    @Override
    @SneakyThrows
    public Mono<ClientResponse> registerClient(ClientRequest clientRequest, String customerNumber) {
        return GenericWebclient.postForSingleObjResponse(AppConstants.CLIENT_URL,clientRequest, ClientRequest.class, ClientResponse.class);
    }



}
