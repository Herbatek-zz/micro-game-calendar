package com.piotrke;

import com.piotrke.external.GameSeriesRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class GameSeriesService {

    @Inject
    private GameSeriesRepository gsRepository;

    Optional<GameSeries> findGameSeriesByName(String name) {
        return gsRepository.findByName(name);
    }

    @Transactional
    public GameSeries addToSeries(GameSeries gameSeries, Set<String> games) {
        gameSeries.getGamesId().addAll(games);
        gsRepository.persistAndFlush(gameSeries); // TODO: 28.02.2020 exception persist
        return gsRepository.findByName(gameSeries.getName()).orElseThrow(() -> new RuntimeException("Update series has failed"));
    }

    @Transactional
    public GameSeries create(GameSeriesRequest gameSeriesRequest) {
        gsRepository.persistAndFlush(GameSeriesConverter.convert(gameSeriesRequest));
        return gsRepository.findByName(gameSeriesRequest.getName()).orElseThrow(() -> new RuntimeException("Save series has failed"));
    }
}
