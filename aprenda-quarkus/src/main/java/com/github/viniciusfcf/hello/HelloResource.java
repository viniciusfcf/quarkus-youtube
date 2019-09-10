package com.github.viniciusfcf.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Path("/quarkus")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloQuarkus() {
        return "hello quarkus";
    }
}