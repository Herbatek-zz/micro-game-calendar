package com.piotrke.gameservice.routers;

import com.piotrke.gameservice.handlers.GameHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class GameRouter {

    @Bean
    RouterFunction<ServerResponse> createGame(GameHandler handler) {
        return RouterFunctions.route(RequestPredicates
                        .POST("/")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON))
                        .and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)),
                handler::createGame);
    }

    @Bean
    RouterFunction<ServerResponse> findGameById(GameHandler handler) {
        return RouterFunctions.route(RequestPredicates
                        .GET("/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                handler::findGameById);
    }

    @Bean
    RouterFunction<ServerResponse> updateGame(GameHandler handler) {
        return RouterFunctions.route(RequestPredicates
                        .PUT("/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON))
                        .and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)),
                handler::updateGame);
    }

    @Bean
    RouterFunction<ServerResponse> deleteGame(GameHandler handler) {
        return RouterFunctions.route(RequestPredicates.DELETE("/{id}"), handler::deleteGame);
    }
}
