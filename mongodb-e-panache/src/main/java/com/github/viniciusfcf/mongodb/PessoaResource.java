package com.github.viniciusfcf.mongodb;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/pessoas")
public class PessoaResource {

	@Inject
	PessoaRepository repository;
	
	@GET
	@Path("adicionar")
	public void addPessoa(@QueryParam("nome") String nome, @QueryParam("idade") Integer idade) {
		Pessoa p = new Pessoa();
		p.nome = nome;
		p.idade = idade;
		p.persist();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getAll() {
		return Pessoa.listAll();
	}
	
	@GET
	@Path("de-maior")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getDeMaior() {
		return repository.findMaiorDeIdade();
	}
}
