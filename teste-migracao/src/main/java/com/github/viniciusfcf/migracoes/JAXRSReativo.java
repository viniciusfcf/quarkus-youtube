package com.github.viniciusfcf.migracoes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Multi;

@Path("/reativo")
public class JAXRSReativo {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Multi<Integer> methodname() {
        return Multi.createFrom().items(1, 2, 3, 4);
    }
}