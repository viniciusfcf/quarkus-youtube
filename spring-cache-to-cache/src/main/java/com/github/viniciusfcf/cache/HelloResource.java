package com.github.viniciusfcf.cache;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/cache")
public class HelloResource {

    private static final Object OBJ = new Object();
    
    @Inject
    MeuServicoDemorado servico;


    @GET
    @Path("primeiro/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String primeiro(@PathParam("id") String id) {
        return servico.primeiroCacheavel(id, new Object());
    }

    @GET
    @Path("primeiro-mesmo-objeto/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String segundo(@PathParam("id") String id) {
        return servico.primeiroCacheavel(id, OBJ);
    }

    @DELETE
    @Path("primeiro-todo")
    @Produces(MediaType.TEXT_PLAIN)
    public void limpeTudo() {
        servico.limpePrimeiroCacheTodo();
    }

    @DELETE
    @Path("primeiro/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public void limpeUm(@PathParam("id") String id) {
        servico.limpePrimeiroCache(id, OBJ);
    }

    @GET
    @Path("put-primeiro-mesmo-objeto/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String segundoCache(@PathParam("id") String id) {
        return servico.segundoCacheavel(id, OBJ);
    }
}