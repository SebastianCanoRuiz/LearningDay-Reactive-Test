package co.com.bancolombia.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {Handler.class, RouterRest.class}
)
public class HandlerTest {

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void beforeEach() {
    }

    @Test
    void listenGETUseCase() {
        webTestClient
                .get()
                .uri("http://localhost:8080/api/example1")
                .exchange()
                .expectStatus()
                .isOk();
    }
}