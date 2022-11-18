package com.company.lms.services;

import com.company.lms.model.res.GenericResponse;
import com.company.lms.model.soap.Customer;
import com.company.lms.model.soap.Transactions;
import com.company.lms.model.soap.TransactionsResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SoapRequestService {
    Mono<GenericResponse> fetchKYC(String customerNumber);
    Flux<Transactions> fetchTransactionsHistory(String customerNumber);
}
