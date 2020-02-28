package com.piotrke;

import com.piotrke.external.GameSeriesRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Optional;

@Path("/game-series")
public class GameSeriesController {

    @Inject
    private GameSeriesService gsService;

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGameSeriesByName(@PathParam(value = "name") String name) {
        return gsService.findGameSeriesByName(name)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addToGameSeries(GameSeriesRequest gameSeriesRequest) {
        Optional<GameSeries> gameSeriesDb = gsService.findGameSeriesByName(gameSeriesRequest.getName());
        if (gameSeriesDb.isPresent()) {
            GameSeries gameSeries = gsService.addToSeries(gameSeriesDb.get(), gameSeriesRequest.getGames());
            return Response.created(URI.create("/game-series/" + gameSeries.getName())).entity(gameSeries).build();
        } else {
            GameSeries gameSeries = gsService.create(gameSeriesRequest);
            return Response.ok(gameSeries).build();
        }
    }
}
