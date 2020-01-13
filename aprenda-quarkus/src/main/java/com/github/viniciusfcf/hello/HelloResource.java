package com.github.viniciusfcf.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

@Path("/hello")
public class HelloResource {

    private static final Logger LOGGER = Logger.getLogger(HelloResource.class);
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOGGER.infov("Olá {0}", "João");
        return "hello";
    }
    
    @GET
    @Path("/quarkus")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloQuarkus() {
        try {
            throw new NullPointerException("Erro proposital");
        }catch(Exception e) {
            LOGGER.info("Olá Quarkus", e);
        }
        return "hello quarkus";
    }
}