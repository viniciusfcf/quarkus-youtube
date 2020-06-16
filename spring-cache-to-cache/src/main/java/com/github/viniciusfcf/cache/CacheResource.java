package com.github.viniciusfcf.cache;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/cache")
public class CacheResource {

    private static final Object OBJ = new Object();
    
    @Inject
    MeuServicoDemorado servico;


    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String primeiro(@PathParam("id") String id) {
        return servico.primeiroCacheavel(id, new Object());
    }

    @GET
    @Path("mesmo-objeto/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String segundo(@PathParam("id") String id) {
        return servico.primeiroCacheavel(id, OBJ);
    }

    @DELETE
    @Path("tudo")
    @Produces(MediaType.TEXT_PLAIN)
    public void limpeTudo() {
        servico.limpePrimeiroCacheTodo();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public void limpeUm(@PathParam("id") String id) {
        servico.limpePrimeiroCache(id, OBJ);
    }

    @GET
    @Path("put-mesmo-objeto/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String segundoCache(@PathParam("id") String id) {
        return servico.segundoCacheavel(id, OBJ);
    }
}