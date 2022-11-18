package com.company.lms.services;

import com.company.lms.db.LoanRequestEntity;
import com.company.lms.model.req.LoanRequest;
import com.company.lms.model.res.GenericResponse;
import reactor.core.publisher.Mono;

public interface LoanService {
    Mono<GenericResponse<LoanRequestEntity>> requestLoan(LoanRequest loanRequest);
    Mono<GenericResponse<LoanRequestEntity>> requestLoanStatus(Long loanId);
}
