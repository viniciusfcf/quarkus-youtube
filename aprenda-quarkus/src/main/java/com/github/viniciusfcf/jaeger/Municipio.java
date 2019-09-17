package com.github.viniciusfcf.jaeger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Municipio {

	@Id
	private Integer id;
	
	private String nome;
	
	private Integer idUF;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdUF() {
		return idUF;
	}

	public void setIdUF(Integer idUF) {
		this.idUF = idUF;
	}
	
}
