package com.github.viniciusfcf.corporativo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author vinicius.ferraz@gmail.com
 *
 */
@Path("/ufs")
@Transactional
public class UnidadeFederativaResource {

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<UnidadeFederativa> getUfs() {
		return UnidadeFederativa.getUfs();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public UnidadeFederativa getUF(@PathParam( "id") Integer id) {
		
		if(id.equals(-2)) {
			//simulando um nullpointer
			throw new NullPointerException();
		}
		
		//Apenas demonstrando tracing com Jaeger, não foi criado banco de dados propositalmente
		Optional<UnidadeFederativa> op = UnidadeFederativa.getUfs().stream().filter(uf -> uf.getId().equals(id)).findFirst();
		//Sugestão de vídeos:
		//Optional: https://www.youtube.com/watch?v=hmU2QEEc4sU
		//Method Reference: https://www.youtube.com/watch?v=9c561GQtyTs
		return op.orElseThrow(NotFoundException::new); 
	}
	
}
