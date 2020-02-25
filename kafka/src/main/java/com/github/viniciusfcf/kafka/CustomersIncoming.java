package com.github.viniciusfcf.kafka;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.vertx.axle.core.eventbus.EventBus;

@ApplicationScoped
public class CustomersIncoming {

	@Inject
	EventBus bus;
	
	@Incoming("customers")
	public void handle(String evento) {
		bus.publish("olaPublish", evento);
		System.out.println("CustomersIncoming.handle() "+evento);
	}
	
}
