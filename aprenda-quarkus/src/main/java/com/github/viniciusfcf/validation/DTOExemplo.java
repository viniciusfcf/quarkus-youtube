package com.github.viniciusfcf.validation;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOExemplo {

	@Min(value = 1, message = "Numero tem que ser maior que 1")
	@Max(value = 10, message = "Numero tem que ser menor que 10")
	@NotNull
	private Long numero;

	@Email
	private String email;

	@Future
	private LocalDateTime dataFuturo;
	
	@NotEmpty
	private Collection<Object> lista;

	@Size(min = 10, message = "Nome maior que 10")
	@NotNull
	private String nome;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataFuturo() {
		return dataFuturo;
	}

	public void setDataFuturo(LocalDateTime dataFuturo) {
		this.dataFuturo = dataFuturo;
	}

	public Collection<Object> getLista() {
		return lista;
	}

	public void setLista(Collection<Object> lista) {
		this.lista = lista;
	}

	public Long getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
}