package com.github.viniciusfcf.grpc;

import javax.inject.Singleton;

import com.github.viniciusfcf.proto.service.UsuarioRequest;
import com.github.viniciusfcf.proto.service.UsuarioResponse;
import com.github.viniciusfcf.proto.service.MutinyUsuarioServiceGrpc.UsuarioServiceImplBase;

import io.smallrye.mutiny.Uni;

@Singleton
public class UsuarioService extends UsuarioServiceImplBase {

    @Override
    public Uni<UsuarioResponse> adicionarUsuario(UsuarioRequest request) {
        Integer id = 999;
        UsuarioResponse usuarioResponse = UsuarioResponse.newBuilder()
                                    .setId(id)
                                    .setNome(request.getNome()+" GRPC")
                                    .setIdade(request.getIdade())
                                    .build();
        return Uni.createFrom().item(usuarioResponse);
    }
}