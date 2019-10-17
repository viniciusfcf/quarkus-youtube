package com.github.viniciusfcf.panache;

import com.github.viniciusfcf.panache.Pessoa.Tipo;

public class IncluirPessoaDTO {

    private String nome;

    private Tipo tipo;

    public String getNome() {
        return nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
