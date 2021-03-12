package com.github.viniciusfcf.grpc;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.viniciusfcf.proto.service.UsuarioRequest;

@Path("/hello")
public class HelloResource {

    @Inject
    UsuarioService usuarioService;
    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("grpc/block")
    public String block() {
        UsuarioRequest request = UsuarioRequest.newBuilder().setIdade(35).setNome("Vinicius").build();
        return usuarioService.adicionarUsuario(request).getNome();
    }

    
}