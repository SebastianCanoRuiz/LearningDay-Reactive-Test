package co.com.bancolombia.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET("/api/initial"), handler::initial)
            .andRoute(GET("/api/validate-response"), handler::validateResponse)
            .andRoute(GET("/api/validate-list-response"), handler::validateListResponse)
            .andRoute(POST("/api/example2"), handler::listenPOSTUseCase);

    }
}
