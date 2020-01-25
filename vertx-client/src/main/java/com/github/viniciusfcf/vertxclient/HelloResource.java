package com.github.viniciusfcf.vertxclient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class HelloResource {

	@ConsumeEvent(value="greeting2", local=false)
	public String consume(String name) {
		System.out.println("HelloResource.consume()");
		return name.toUpperCase()+" 2";
	}
	
	@ConsumeEvent(value="greeting2", local=false)
	public String consume2(String name) {
		System.out.println("HelloResource.consume2()");
		
		return name.toUpperCase()+" 2";
	}
}