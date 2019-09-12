package com.github.viniciusfcf.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/produtos")
@Transactional
public class ProdutosResource {

	@Inject EntityManager entityManager;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Produto> getProdutos() {
		return entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public void addProduto(Produto p) {
		entityManager.persist(p);
	}
	
}
