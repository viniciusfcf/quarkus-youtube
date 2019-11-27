package com.github.viniciusfcf.elasticsearch;

import java.util.List;
import java.util.Optional;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.quarkus.runtime.StartupEvent;

@Path("/autores")
public class AutorResource {

    @Inject ElasticsearchService elasticsearchService;
	@Transactional 
    void onStart(@Observes StartupEvent ev) throws InterruptedException { 
        elasticsearchService.rebuildIndexes();
    }
    
	@GET
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public List<Autor> searchAuthors(@QueryParam("termo") String termo, @QueryParam("tamanho") Optional<Integer> tamanho) {
		return elasticsearchService.search(Autor.class, termo, tamanho, "nome", "livros.titulo", "livros.conteudo");
	}
}