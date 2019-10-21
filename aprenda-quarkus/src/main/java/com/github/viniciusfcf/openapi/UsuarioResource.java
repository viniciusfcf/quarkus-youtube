package com.github.viniciusfcf.openapi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@Path("/usuarios")
@Tag(name = "usuarios")
public class UsuarioResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Busca todos os usuários, mesmo que tenham sido apagados logicamente", summary = "Busca usuários cadastrados no sistema")
    public List<Usuario> buscarUsuarios() {
        return Usuario.listAll();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String adicionarUsuario(@RequestBody Usuario usuario) {
        return "hello";
    }

    @GET
    @Path("{idUsuario}/produtos")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Busca os produtos de um usuário")
    @Tag(name="usuarios")
    @Tag(name="produtos")
    @APIResponse(responseCode = "404", description = "Caso o usuário não exista")
    @APIResponse(responseCode = "200", description = "Ok")
    public List<Usuario> buscarUsuarios(@QueryParam("idUsuario") Integer idUsuario) {
        return Usuario.listAll();
    }
}