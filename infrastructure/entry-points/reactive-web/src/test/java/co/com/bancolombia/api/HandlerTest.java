package co.com.bancolombia.api;

import co.com.bancolombia.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    void initial() {
        webTestClient
                .get()
                .uri("http://localhost:8080/api/initial")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void validateResponse() {
        String resp = "Response Validate";

        webTestClient
                .get()
                .uri("http://localhost:8080/api/validate-response")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo(resp);
    }

    @Test
    void validateListResponse() {
        List<Person> resp = new ArrayList<>();
        resp.add(new Person(19, "Evaristo"));
        resp.add(new Person(23, "MAria"));
        resp.add(new Person(16, "Armenia"));

        webTestClient
                .get()
                .uri("http://localhost:8080/api/validate-list-response")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Person.class).hasSize(3)
                .isEqualTo(resp);
    }
}