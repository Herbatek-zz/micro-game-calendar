package com.piotrke;

import com.piotrke.external.GameSeriesRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameSeriesConverter {

    static GameSeries convert(GameSeriesRequest request) {
        GameSeries gameSeries = new GameSeries();
        gameSeries.setName(request.getName());
        gameSeries.setGamesId(request.getGames());
        gameSeries.setDescription(request.getDescription());
        gameSeries.setImageUrl(request.getImage());
        return gameSeries;
    }
}
