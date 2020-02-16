package com.github.viniciusfcf.kafka;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;

@Path("precos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrecoResource {

	@Inject
	@Channel("preco-adicionado")
	Emitter<Double> priceEmitter;

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void addPrice(Double price) {
		priceEmitter.send(price);
	}


}