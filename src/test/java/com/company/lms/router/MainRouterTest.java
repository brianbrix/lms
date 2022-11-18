package com.company.lms.router;

import com.company.lms.exceptions.GenericException;
import com.company.lms.model.req.Subscription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MainRouterTest {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void routes() {
    }

    @BeforeEach
    public void setUp() {
        webTestClient = webTestClient.mutate()
                .responseTimeout(Duration.ofMillis(30000))
                .build();
    }
    @Test
    void testSubscribeFails(){
        webTestClient.post().uri("/subscribe")
                .body(BodyInserters.fromValue(new Subscription("cus")))

                .exchange()
                .expectStatus().isBadRequest().expectBody(GenericException.class).isEqualTo(new GenericException("Customer Number not found."));
    }
}