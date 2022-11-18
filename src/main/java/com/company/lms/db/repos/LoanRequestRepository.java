package com.company.lms.db.repos;

import com.company.lms.db.LoanRequestEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface LoanRequestRepository extends ReactiveCrudRepository<LoanRequestEntity, Long> {
    @Query("SELECT l.* FROM loan_requests l WHERE l.customer_number=:customerNumber AND l.status IN (:statuses)")
    Mono<LoanRequestEntity> findByCustomerNumberAndStatus(String customerNumber, List<String> statuses);
}
