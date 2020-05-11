package com.github.viniciusfcf.springweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

// @RestController
// @RequestMapping(path="/produtos", consumes="application/json", produces = "application/json")
@Path("produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoController {


    private Map<Long, Produto> produtos = new HashMap<>();
    
    public ProdutoController() {
        Produto produto1 = new Produto();
        produto1.setId(1L);
        produto1.setNome("Nescau");
        adicionarProduto(produto1);
        Produto produto2 = new Produto();
        produto2.setId(2L);
        produto2.setNome("Cerveja");
		adicionarProduto(produto2);

    }


    // @GetMapping("/{id}")
    @GET
    @Path("/{id}")
    public Produto getById(
        // @PathVariable(name = "id") 
        @PathParam("id")
        Long id) {
        return produtos.get(id);
    }

    // @GetMapping
    @GET
    public List<Produto> buscarProdutos(
        // @RequestParam(name = "nome") 
        @QueryParam("nome")
        String nome) {
        if(StringUtils.isBlank(nome)) {
            return new ArrayList<Produto>(produtos.values());

        }
        return new ArrayList<Produto>(produtos.values().stream().filter(s -> s.getNome().equals(nome)).collect(Collectors.toList()));
    }

    // @PostMapping
    @POST
    public void addProduto(
        // @RequestBody 
        Produto produto) {
        adicionarProduto(produto);
    }

    // @PutMapping("/{id}")
    @PUT
    @Path("/{id}")
    public void atualizarProduto(
        // @PathVariable(name = "id") 
        @PathParam("id")
        Long id, Produto produto) {
        produto.setId(id);
        adicionarProduto(produto);

    }

    // @PatchMapping("/{id}")
    @PATCH
    @Path("/{id}")
    public void atualizarProduto2(
        // @PathVariable(name = "id") 
        @PathParam("id")
        Long id, Produto produto) {
        produto.setId(id);
        adicionarProduto(produto);
    }


    // @DeleteMapping("/{id}")
    @DELETE
    @Path("/{id}")
    public void deleteById(
        // @PathVariable(name = "id") 
        @PathParam("id")
        Long id) {
        produtos.remove(id);
    }


    // @GetMapping("/excecao")
    @GET
    @Path("/excecao")
    public void excecao() {
        throw new IllegalArgumentException();
    }

    private void adicionarProduto(Produto produto) {
        produtos.put(produto.getId(), produto);
    }
}
