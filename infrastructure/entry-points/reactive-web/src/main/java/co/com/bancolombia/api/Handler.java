package co.com.bancolombia.api;

import co.com.bancolombia.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Handler {
//private  final UseCase useCase;
//private  final UseCase2 useCase2;
    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("Algo");
    }

    public Mono<ServerResponse> validateResponse(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Response Validate");
    }

    public Mono<ServerResponse> validateListResponse(ServerRequest serverRequest) {
        List<Person> resp = new ArrayList<>();
        resp.add(new Person(19, "Evaristo"));
        resp.add(new Person(23, "MAria"));
        resp.add(new Person(16, "Armenia"));

        return ServerResponse.ok().body(Mono.just(resp), List.class);
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
