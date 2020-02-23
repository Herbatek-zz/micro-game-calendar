package com.piotrke.gameservice.repositories;

import com.piotrke.gameservice.entities.Game;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface GameRepository extends ReactiveCrudRepository<Game, UUID> {
}
