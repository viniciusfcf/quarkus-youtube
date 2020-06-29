package com.github.viniciusfcf.grpc;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.viniciusfcf.proto.service.UsuarioRequest;
import com.github.viniciusfcf.proto.service.UsuarioServiceGrpc.UsuarioServiceBlockingStub;

import io.quarkus.grpc.runtime.annotations.GrpcService;

@Path("/hello")
public class HelloResource {

    @Inject
    @GrpcService("usuarios")
    UsuarioServiceBlockingStub usuarioService;
    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("grpc/block")
    @Produces(MediaType.TEXT_PLAIN)
    public String block() {
        UsuarioRequest request = UsuarioRequest.newBuilder().setIdade(35).setNome("Vinicius").build();
        return usuarioService.adicionarUsuario(request).getNome();
    }

    
}