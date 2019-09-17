package com.github.viniciusfcf.hibernate;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.microprofile.opentracing.Traced;

@ApplicationScoped
@Traced
public class ProdutoService {

	@Inject EntityManager entityManager;
	
	public List<Produto> getProdutos() {
		return entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
	}
	
	public void addProduto(Produto p) {
		entityManager.persist(p);
	}
	
}
