package com.github.viniciusfcf.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/produtos")
@Transactional
public class ProdutoResource {

	@Inject ProdutoService produtoService;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Produto> getProdutos() {
		return produtoService.getProdutos();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public void addProduto(Produto p) {
		produtoService.addProduto(p);
	}
	
}
