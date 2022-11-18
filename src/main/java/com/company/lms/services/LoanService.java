package com.company.lms.services;

import com.company.lms.db.LoanRequestEntity;
import com.company.lms.model.req.LoanRequest;
import com.company.lms.model.res.GenericResponse;
import com.company.lms.model.res.ScoreInitResponse;
import com.company.lms.model.res.ScoreResponse;
import reactor.core.publisher.Mono;

public interface LoanService {
    Mono<GenericResponse<LoanRequestEntity>> requestLoan(LoanRequest loanRequest);
    Mono<GenericResponse<LoanRequestEntity>> requestLoanStatus(Long loanId);
    Mono<ScoreInitResponse> initScoreRequest(String customerNumber);
    Mono<ScoreResponse> getScore(String token);
}
