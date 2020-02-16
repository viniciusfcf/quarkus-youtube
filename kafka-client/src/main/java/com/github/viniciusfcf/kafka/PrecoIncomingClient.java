package com.github.viniciusfcf.kafka;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;

@ApplicationScoped
public class PrecoIncomingClient {

	@Incoming("preco-gerado-to-cluster")
    @Outgoing("preco-gerado-in-memory")                          
    @Broadcast                                           
	public Double precoGerado(Double preco) {
		System.out.println("CLIENT --> precoGerado() " + preco);
		return preco;
	}
	

}