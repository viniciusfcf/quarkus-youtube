package com.github.viniciusfcf.vertxclient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class OlaHandler2 {

	@ConsumeEvent(value="olaRequest", local=false)
	public String consume(String name) {
		return name.toUpperCase()+" Quarkus 2!!";
	}
	
}