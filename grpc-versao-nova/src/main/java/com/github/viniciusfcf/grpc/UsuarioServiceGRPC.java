package com.github.viniciusfcf.grpc;

import javax.inject.Singleton;

import com.github.viniciusfcf.proto.service.UsuarioRequest;
import com.github.viniciusfcf.proto.service.UsuarioResponse;
import com.github.viniciusfcf.proto.service.UsuarioServiceGrpc.UsuarioServiceImplBase;

import io.grpc.stub.StreamObserver;

@Singleton
public class UsuarioServiceGRPC extends UsuarioServiceImplBase {

    @Override
    public void adicionarUsuario(UsuarioRequest request
    , StreamObserver<UsuarioResponse> responseObserver) {
        Integer id = 999;
        UsuarioResponse usuarioResponse = UsuarioResponse.newBuilder()
                                    .setId(id)
                                    .setNome(request.getNome()+" GRPC")
                                    .setIdade(request.getIdade())
                                    .build();
        responseObserver.onNext(usuarioResponse);         
        responseObserver.onCompleted();  
    }
}