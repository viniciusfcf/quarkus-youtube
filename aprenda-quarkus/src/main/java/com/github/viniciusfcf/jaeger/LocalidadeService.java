package com.github.viniciusfcf.jaeger;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class LocalidadeService {

	@Inject EntityManager entityManager;
	
	@Inject @RestClient UnidadeFederativaService ufService;
	
	public List<Municipio> getMunicipios() {
		return entityManager.createQuery("select m from Municipio m", Municipio.class).getResultList();
	}
	
	public void addMunicipio(Municipio p) {
		entityManager.persist(p);
	}
	
	public UnidadeFederativa getUF(Integer id) {
		return ufService.getUF(id);
	}
	
}
