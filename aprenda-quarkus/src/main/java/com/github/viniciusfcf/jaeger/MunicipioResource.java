package com.github.viniciusfcf.jaeger;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/municipios")
@Transactional
public class MunicipioResource {

	@Inject LocalidadeService localidadeService;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Municipio> getMunicipios() {
		return localidadeService.getMunicipios();
	}
	
	@GET
	@Path("{idMunicipio}/uf")
	@Produces(value = MediaType.APPLICATION_JSON)
	public UnidadeFederativa getUF(@PathParam("idMunicipio") Integer idMunicipio) {
		Optional<Municipio> municipio = localidadeService.getMunicipios().stream().filter(m -> idMunicipio.equals(m.getId())).findFirst();
		if(!municipio.isPresent()) {
			throw new NotFoundException();
		}
		return localidadeService.getUF(municipio.get().getIdUF());
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public void addMunicipio(Municipio m) {
		localidadeService.addMunicipio(m);
	}
	
}
