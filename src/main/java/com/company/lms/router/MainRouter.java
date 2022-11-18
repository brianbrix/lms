package com.company.lms.router;

import com.company.lms.services.LoanService;
import com.company.lms.services.SoapRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class MainRouter {
    private final SoapRequestService soapRequestService;
    private final LoanService loanService;
//    private final MainHandler mainHandler;
@Bean
public RouterFunction<ServerResponse> testRoute(MainHandler mainHandler)
{
    System.out.println("Hello");
    return route(GET("test").and(accept(TEXT_PLAIN)),mainHandler::testHandler);
}
    @Bean
    public RouterFunction<ServerResponse> routes(MainHandler mainHandler) {
        System.out.println("Hello");
        return route(
                GET("/test3"), mainHandler::testHandler)
                .andRoute(GET("transactions/{customerNumber}"),request -> soapRequestService.fetchTransactionsHistory(request.pathVariable("customerNumber")).collectList().flatMap(res->ServerResponse.status(HttpStatus.OK).body(BodyInserters.fromValue(res))))
                .andRoute(POST("/subscribe"), mainHandler::subscribe)
                .andRoute(POST("/requestLoan"), mainHandler::requestLoan)
                .andRoute(GET("/loans/status/{loanId}"), req->loanService.requestLoanStatus(Long.parseLong(req.pathVariable("loanId"))).flatMap(res->ServerResponse.status(HttpStatus.OK).body(BodyInserters.fromValue(res))));


    }
}
