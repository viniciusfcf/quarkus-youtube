package com.github.viniciusfcf.springweb;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoController {

    // @Autowired
    @Inject
    ProdutoService produtoService;

    @GET
    @Path("novo-nome")
    @Produces(MediaType.TEXT_PLAIN)
    public String novoNome(@QueryParam("nome") String nome) {
        return produtoService.novoNome(nome);
    }

}
