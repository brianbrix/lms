package com.company.lms.scheduler;

import com.company.lms.db.repos.LoanRequestRepository;
import com.company.lms.services.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Log4j2
@Component
@EnableScheduling
@RequiredArgsConstructor
public class LoanScheduler {
    private final LoanService loanService;
    private final LoanRequestRepository loanRequestRepository;
    @Scheduled(fixedDelay = 1000)
    public void processLoan()
    {
    loanRequestRepository.findAllByStatus("NEW")
            .publishOn(Schedulers.boundedElastic())
            .subscribe(loanRequestEntity -> {
                loanRequestEntity.setStatus("PENDING");
                 loanService.initScoreRequest(loanRequestEntity.getCustomerNumber())
                                .subscribeOn(Schedulers.boundedElastic())
                                .subscribe(res->loanService.getScore(res.getToken()).subscribe(res2->
                                {
                                    if (res2.getLimitAmount()<=loanRequestEntity.getAmount())
                                    {
                                        log.info("AMOUNT IS OKAY: {}",res2.getLimitAmount());
                                        loanRequestEntity.setStatus("APPROVED");
                                    }
                                    else
                                    {
                                        log.info("AMOUNT IS NOT OKAY: {}",res2.getLimitAmount());

                                        loanRequestEntity.setStatus("REJECTED");
                                    }
                                } ));
                 loanRequestRepository.save(loanRequestEntity).subscribe(saved->log.info("SAVED: {}", saved));
                    });

    }
}
