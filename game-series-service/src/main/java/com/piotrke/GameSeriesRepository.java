package com.piotrke;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class GameSeriesRepository implements PanacheRepository<GameSeries> {
    Optional<GameSeries> findByName(String name) {
        return find("name", name).firstResultOptional();
    }
}
