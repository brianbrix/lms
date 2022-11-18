package com.company.lms.db.repos;

import com.company.lms.db.CustomerKYC;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface KYCRepository extends ReactiveCrudRepository<CustomerKYC, Long> {
    Mono<CustomerKYC> findByCustomerNumber(String customerNumber);
}
