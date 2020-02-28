package com.piotrke;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class GameSeriesService {

    @Inject
    private GameSeriesRepository gsRepository;

    Optional<GameSeries> findGameSeriesByName(String name) {
        return gsRepository.findByName(name);
    }
}
