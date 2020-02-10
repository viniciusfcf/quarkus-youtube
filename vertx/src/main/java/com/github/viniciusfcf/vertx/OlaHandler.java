package com.github.viniciusfcf.vertx;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class OlaHandler {

	@ConsumeEvent(value="olaRequest", local = false)
	public String consume(String name) {
		return "OK from Quarkus: "+name;
	}
	
//	@ConsumeEvent("olaRequest")
//	public CompletionStage<String> consume2(String name) {
//		name+="2";
//	    return CompletableFuture.supplyAsync(name::toUpperCase);
//	}
//	
//	@ConsumeEvent("olaPublish")
//	public void consumeVoid(String event) {
//	    // Do something with the event
//	}
	
//	@ConsumeEvent("olaPublish")
//	public void consumeMessage(Message<String> msg) {
//	    System.out.println(msg.address());
//	    System.out.println(msg.body());
//	    msg.replyAndRequest("Oxe");
//	}
}