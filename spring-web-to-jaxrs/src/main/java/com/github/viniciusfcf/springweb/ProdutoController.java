package com.github.viniciusfcf.springweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/produtos", consumes="application/json", produces = "application/json")
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


	@GetMapping("/{id}")
    public Produto getById(@PathVariable(name = "id") Long id) {
        return produtos.get(id);
    }

    @GetMapping
    public List<Produto> buscarProdutos(@RequestParam(name = "nome") String nome) {
        if(StringUtils.isBlank(nome)) {
            return new ArrayList<Produto>(produtos.values());

        }
        return new ArrayList<Produto>(produtos.values().stream().filter(s -> s.getNome().equals(nome)).collect(Collectors.toList()));
    }

    @PostMapping
    public void addProduto(@RequestBody Produto produto) {
        adicionarProduto(produto);
    }

    @PutMapping("/{id}")
    public void atualizarProduto(@PathVariable(name = "id") Long id, Produto produto) {
        produto.setId(id);
        adicionarProduto(produto);

    }

    @PatchMapping("/{id}")
    public void atualizarProduto2(@PathVariable(name = "id") Long id, Produto produto) {
        produto.setId(id);
        adicionarProduto(produto);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        produtos.remove(id);
    }


    @GetMapping("/excecao")
    public ResponseEntity<?> excecao() {
        throw new IllegalArgumentException();
    }

    private void adicionarProduto(Produto produto) {
        produtos.put(produto.getId(), produto);
    }
}
