package com.github.viniciusfcf.mongodb;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class PessoaRepository implements PanacheMongoRepository<Pessoa> {

	public List<Pessoa> findMaiorDeIdade() {
		return list("idade > ?1", 18);
	}
}
