package com.github.viniciusfcf.mongodb;

import java.util.List;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "pessoas")
public class Pessoa extends PanacheMongoEntity {

	public String nome;
	
	public Integer idade;
	
	
	public static List<Pessoa> findMaiorDeIdade() {
		return list("idade > ?1", 18);
	}
}
