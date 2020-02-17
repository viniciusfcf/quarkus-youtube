package com.github.viniciusfcf.kafka;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class PrecoIncomingClient {

	@Incoming("preco-gerado-to-cluster")
	@Outgoing("preco-gerado-in-memory")
	public Double precoGerado(Double preco) {
		System.out.println("CLIENT --> precoGerado() " + preco);
		return preco + 10;
	}

}