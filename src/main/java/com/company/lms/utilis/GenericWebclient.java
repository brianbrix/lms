package com.company.lms.utilis;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.util.retry.Retry;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * This class provides a generic template for making POST and GET request
 */
@Log4j2
public class GenericWebclient {
    private static final long TIMEOUT = 5000;
    private static final int CONNECT_TIMEOUT = 5000;
    /**
     *
     * @param url - String endpoint
     * @param request -Object of type T
     * @param requestClass classType of T in the form T.class
     * @param responseClass classType of V in the form V.class
     * @return
     * @param <T>
     * @param <V>
     * @throws URISyntaxException
     * toDo: Define custom exceptions
     * NOTE: Custom Exceptions must in order of 4xx to 5xx
     */
    public  static<T ,V, E extends Exception> Mono<V> postForSingleObjResponse(String url, T request, Class<T> requestClass, Class<V> responseClass) throws URISyntaxException {
    log.info("REQUEST: {}", request);
        return myWebClient().post()
                .uri(new URI(url))
                .body(Mono.just(request), requestClass)
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, error->Mono.error(new RuntimeException("Internal server error occurred.")))
                .onStatus(HttpStatus::is4xxClientError, error->Mono.error(new RuntimeException("Bad Request Error.")))
                .bodyToMono(responseClass)
                .onErrorResume(Mono::error)
                .retryWhen(Retry.backoff(3,Duration.of(2, ChronoUnit.SECONDS)).onRetryExhaustedThrow(((retryBackoffSpec, retrySignal) -> new Throwable(retrySignal.failure()))));



    }



    /**
     *
     * @param url - String endpoint
     * @param responseClass classType of V in the form V.class
     * @return
     * @param <V>
     * @throws URISyntaxException
     */
    public  static<V, E extends Exception> Mono<V> getForSingleObjResponse(String url, Class<V> responseClass) throws URISyntaxException {
        return myWebClient().get()
                .uri(new URI(url))
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, error->Mono.error(new RuntimeException("Internal server error occurred.")))
                .onStatus(HttpStatus::is4xxClientError, error->Mono.error(new RuntimeException("Bad Request Error.")))
                .bodyToMono(responseClass);

    }

    public  static<V, E extends Exception> Mono<V> getForSingleObjResponseWithExponentialRetries(String url, Class<V> responseClass) throws URISyntaxException {
        return myWebClient().get()
                .uri(new URI(url))
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, error->Mono.error(new RuntimeException("Internal server error occurred.")))
                .onStatus(HttpStatus::is4xxClientError, error->Mono.error(new RuntimeException("Bad Request Error.")))
                .bodyToMono(responseClass)
                .retryWhen(Retry
                        .backoff(3, Duration.ofMillis(100)).jitter(0d)
                        .doAfterRetry(rs -> log.info("Retried at " + LocalTime.now() + ", attempt " + rs.totalRetries()))
                        .onRetryExhaustedThrow((spec, rs) -> rs.failure())
                );

    }

    private static WebClient myWebClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, CONNECT_TIMEOUT)
                .responseTimeout(Duration.ofMillis(TIMEOUT))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS)));

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();



    }



}
