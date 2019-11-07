package com.github.viniciusfcf.restclient;

import java.util.List;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/pets")
public class PetResource {

    @Inject
    @RestClient
    PetService petService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findByStatusLocal")
    public List<Pet> methodname(@QueryParam("status") String status) {
        return petService.findByStatus(status);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findByStatusLocalAsync")
    public CompletionStage<List<Pet>> async(@QueryParam("status") String status) {
        return petService.findByStatusAsync(status);
    }
    
}