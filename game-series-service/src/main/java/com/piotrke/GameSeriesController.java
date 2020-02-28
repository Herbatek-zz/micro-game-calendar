package com.piotrke;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
}
