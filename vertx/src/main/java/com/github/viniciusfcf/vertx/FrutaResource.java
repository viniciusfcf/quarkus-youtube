package com.github.viniciusfcf.vertx;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("frutas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrutaResource {

	@Inject
	FrutaService service;
	
	@GET
	public CompletionStage<Response> buscarFrutas() {
		return service.buscarFrutas()
				.thenApply(Response::ok)
				.thenApply(ResponseBuilder::build);
	}
	
	@PUT
	@Path("/{id}")
	public CompletionStage<Response> atualizar(@PathParam("id") Long id, @RequestBody Fruta fruta) {
		return service.atualizar(id, fruta.getNome())
				.thenApply(retorno -> retorno.intValue() >= 1?Response.ok():Response.status(Status.NOT_FOUND))
				.thenApply(ResponseBuilder::build);
	}
	
	@POST
	public CompletionStage<Response> inserir(@RequestBody Fruta fruta) {
		return service.inserir(fruta.getNome())
				.thenApply(Response::ok)
				.thenApply(ResponseBuilder::build);
	}
	
	@DELETE
	@Path("/{id}")
	public CompletionStage<Response> deletar(@PathParam("id") Long id) {
		return service.deletar(id)
				.thenApply(retorno -> retorno.intValue() >= 1?Response.status(Status.NO_CONTENT):Response.status(Status.NOT_FOUND))
				.thenApply(ResponseBuilder::build);
	}
	

}