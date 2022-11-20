package com.company.lms.router;

import com.company.lms.db.repos.KYCRepository;
import com.company.lms.exceptions.GenericException;
import com.company.lms.model.req.LoanRequest;
import com.company.lms.model.req.Subscription;
import com.company.lms.model.res.GenericResponse;
import com.company.lms.services.LoanService;
import com.company.lms.services.SoapRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
@Log4j2
@Component
@RequiredArgsConstructor
public class MainHandler {
    private final KYCRepository kycRepository;
    private final SoapRequestService soapRequestService;
    private final LoanService loanService;

    public Mono<ServerResponse> subscribe(ServerRequest serverRequest) {
        Mono<Subscription> subscriptionMono = serverRequest.bodyToMono(Subscription.class);
        return subscriptionMono.flatMap(subscription -> kycRepository.findByCustomerNumber(subscription.getCustomerNumber())
                .flatMap(res ->
                        ServerResponse.status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(Mono.just(new GenericResponse<>("SUCCESS","The customer is already subscribed",res)), GenericException.class)
                ).switchIfEmpty(soapRequestService.fetchKYC(subscription.getCustomerNumber())
                        .flatMap(res -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(res))))
                .onErrorResume(error->
                {
                    log.info("ERROR: {}",error.getMessage());
                    return ServerResponse.status(HttpStatus.BAD_REQUEST)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(new GenericResponse<>("FAILED", "Customer number not found", null)));
                })
        );
    }
    public Mono<ServerResponse> testHandler(ServerRequest serverRequest)
    {
        System.out.println("Hello");
        return ServerResponse.ok().body(BodyInserters.fromValue("Testing heartbeat"));
    }
    public Mono<ServerResponse> requestLoan(ServerRequest serverRequest)
    {
        Mono<LoanRequest> loanRequestMono = serverRequest.bodyToMono(LoanRequest.class);
        return loanRequestMono.flatMap(loanRequest ->loanService.requestLoan(loanRequest).flatMap(res -> ServerResponse.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(res))))
                .onErrorResume(error->ServerResponse.badRequest().body(BodyInserters.fromValue(new GenericResponse<>("FAILED", "Unable to create loan request "+error.getMessage(),null))));


    }
}
