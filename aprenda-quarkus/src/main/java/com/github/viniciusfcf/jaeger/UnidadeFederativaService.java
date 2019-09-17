package com.github.viniciusfcf.jaeger;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * @author vinicius.ferraz@gmail.com
 *
 */
@RegisterRestClient
@Path("ufs")
public interface UnidadeFederativaService {

	@Produces(value = MediaType.APPLICATION_JSON)
	public List<UnidadeFederativa> getUfs();
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public UnidadeFederativa getUF(@PathParam( "id") Integer id);
	
}
