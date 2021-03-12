package com.github.viniciusfcf.grpc;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.github.viniciusfcf.proto.service.UsuarioRequest;
import com.github.viniciusfcf.proto.service.UsuarioResponse;
import com.github.viniciusfcf.proto.service.UsuarioServiceGrpc.UsuarioServiceBlockingStub;

import io.quarkus.grpc.runtime.annotations.GrpcService;

@ApplicationScoped
public class UsuarioService {
    
    @Inject
    @GrpcService("usuarios")
    UsuarioServiceBlockingStub usuarioServiceGRPC;

    public UsuarioResponse adicionarUsuario(UsuarioRequest request) {
        return usuarioServiceGRPC.adicionarUsuario(request);
    }

}
