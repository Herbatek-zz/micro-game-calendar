package com.piotrke.gameservice.handlers;

import com.piotrke.gameservice.entities.Game;
import com.piotrke.gameservice.repositories.GameRepository;
import com.piotrke.gameservice.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GameHandler {

    private final GameRepository repository;
    private final GameService service;

    public Mono<ServerResponse> createGame(ServerRequest request) {
        UUID id = UUID.randomUUID();
        URI uri = URI.create("games/" + id);

        Mono<Game> gameMono = request.bodyToMono(Game.class)
                .doOnNext(game -> game.setId(id))
                .flatMap(repository::save);

        return ServerResponse
                .created(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(gameMono, Game.class);
    }

    public Mono<ServerResponse> findGameById(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        Mono<Game> game = repository.findById(id);
        return game.flatMap(g -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromPublisher(game, Game.class)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    // todo: update doesn't work
    public Mono<ServerResponse> updateGame(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        Mono<Game> gameMono = request.bodyToMono(Game.class);
        return repository.findById(id)
                .flatMap(old -> service.updateAllFields(old, gameMono))
                .flatMap(old -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromPublisher(repository.save(old), Game.class)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> deleteGame(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        return repository.findById(id)
                .flatMap(g -> ServerResponse.noContent().build(repository.delete(g)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
