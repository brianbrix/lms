package com.company.lms.scheduler;

import com.company.lms.db.repos.LoanRequestRepository;
import com.company.lms.model.req.ClientRequest;
import com.company.lms.services.LoanService;
import com.company.lms.utilis.AppConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
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
                loanRequestRepository.save(loanRequestEntity).subscribe(saved->log.info("SAVED: {}", saved));
                loanService.registerClient(ClientRequest.builder().url(String.format(AppConstants.LMS_TRANSACTIONS_URL,loanRequestEntity.getCustomerNumber())).name("lms-app").username("lms_user").password("lms_pass").build(), loanRequestEntity.getCustomerNumber())
                                .subscribe(clientResponse ->{
                                    log.info("Client Response: {}", clientResponse);
                                    loanService.initScoreRequest(loanRequestEntity.getCustomerNumber(), clientResponse.getToken())
                                            .subscribeOn(Schedulers.boundedElastic())
                                            .subscribe(initResponse->{
                                                log.info("Init Response: {}", initResponse);
                                                loanService.getScore(initResponse.getToken(), clientResponse.getToken())
                                                        .onErrorResume(error->{
                                                            log.info("Error: {}", error.getMessage());
                                                            loanRequestEntity.setStatus("FAILED");
                                                            loanRequestRepository.save(loanRequestEntity).subscribe(res->log.info("SAVED :{}",res));
                                                            return Mono.empty();
                                                        })
                                                        .subscribe(scoreResponse->
                                                {
                                                    log.info("Score Response: {}", scoreResponse);
                                                    if (scoreResponse.getLimitAmount()<=loanRequestEntity.getAmount())
                                                    {
                                                        log.info("AMOUNT IS OKAY: {}",scoreResponse.getLimitAmount());
                                                        loanRequestEntity.setStatus("APPROVED");
                                                    }
                                                    else
                                                    {
                                                        log.info("AMOUNT IS NOT OKAY: {}",scoreResponse.getLimitAmount());

                                                        loanRequestEntity.setStatus("REJECTED");
                                                    }
                                                });
                                            });
                                } );

                 loanRequestRepository.save(loanRequestEntity).subscribe(saved->log.info("SAVED: {}", saved));
                    });

    }
}
