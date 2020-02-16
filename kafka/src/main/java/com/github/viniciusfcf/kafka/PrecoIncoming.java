package com.github.viniciusfcf.kafka;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PrecoIncoming {

	@Incoming("preco-adicionado")
	public void precoAdicionado(Double preco) {
		System.out.println("PrecoIncoming.precoAdicionado() " + preco);
	}

	@Incoming("preco-gerado")
	public void precoGerado(Double preco) {
		System.out.println("PrecoIncoming.precoGerado() " + preco);
	}
}