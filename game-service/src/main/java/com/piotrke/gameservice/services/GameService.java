package com.piotrke.gameservice.services;

import com.piotrke.gameservice.entities.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class GameService {

    public Mono<Game> updateAllFields(Game oldGame, Mono<Game> newGame) {
        newGame.doOnNext(game -> oldGame.setTitle(game.getTitle()));
        return Mono.just(oldGame);
    }
}
