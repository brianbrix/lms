package com.company.lms.router;

import com.company.lms.model.soap.TransactionsMod;
import com.company.lms.services.LoanService;
import com.company.lms.services.SoapRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class MainRouter {
    private final SoapRequestService soapRequestService;
    private final LoanService loanService;
    @Bean
    public RouterFunction<ServerResponse> testRoute(MainHandler mainHandler)
    {
        return route(GET("test").and(accept(TEXT_PLAIN)),mainHandler::testHandler);
    }

    @Bean
    @RouterOperations(
            {
                    @RouterOperation(path = "transactions/{customerNumber}"
                            , produces = {
                            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET, beanClass = SoapRequestService.class, beanMethod = "fetchTransactionHistory",
                            operation = @Operation(operationId = "fetchTransactionHistory", responses = {
                                    @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = TransactionsMod.class))),
                                    @ApiResponse(responseCode = "404", description = "Customer not found")}, parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "customerNumber")}
                                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = TransactionsMod.class))))
                    ),

            })

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
