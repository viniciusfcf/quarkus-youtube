package com.github.viniciusfcf.restclient;

import java.util.List;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/pet")
@RegisterRestClient
public interface PetService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findByStatus")
    @Timeout(value = 1000)
    public List<Pet> findByStatus(@QueryParam("status") String status);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findByStatus")
    public CompletionStage<List<Pet>> findByStatusAsync(@QueryParam("status") String status);
}