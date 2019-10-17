package com.github.viniciusfcf.panache;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/pessoas")
public class PessoaResource {

    @Inject
    PessoaRepositorio repositorio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> buscarPessoas() {
        return repositorio.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void addPessoa(@RequestBody IncluirPessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setTipo(dto.getTipo());
        pessoa.persist();
        
    }

}