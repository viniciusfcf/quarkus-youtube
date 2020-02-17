package com.github.viniciusfcf.kafka;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import io.smallrye.reactive.messaging.annotations.Channel;

@ApplicationScoped
@Path("precos")
public class PrecoStreamResource {

	@Inject
	@Channel("preco-gerado-in-memory")
	Publisher<Double> precos;

	@GET
	@Path("/stream")
	@Produces(MediaType.SERVER_SENT_EVENTS)
	@SseElementType(MediaType.TEXT_PLAIN)
	public Publisher<Double> stream() {
		return precos;
	}
}
