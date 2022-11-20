package com.company.lms.services;

import com.company.lms.db.LoanRequestEntity;
import com.company.lms.model.req.ClientRequest;
import com.company.lms.model.req.LoanRequest;
import com.company.lms.model.res.ClientResponse;
import com.company.lms.model.res.GenericResponse;
import com.company.lms.model.res.ScoreInitResponse;
import com.company.lms.model.res.ScoreResponse;
import reactor.core.publisher.Mono;

public interface LoanService {
    Mono<GenericResponse<LoanRequestEntity>> requestLoan(LoanRequest loanRequest);
    Mono<GenericResponse<LoanRequestEntity>> requestLoanStatus(Long loanId);
    Mono<ScoreInitResponse> initScoreRequest(String customerNumber, String headerToken);
    Mono<ScoreResponse> getScore(String token, String headerToken);
    Mono<ClientResponse> registerClient(ClientRequest clientRequest, String customerNumber);
}
