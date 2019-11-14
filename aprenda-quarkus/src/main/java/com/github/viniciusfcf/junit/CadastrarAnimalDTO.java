package com.github.viniciusfcf.junit;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class CadastrarAnimalDTO {

    @Schema(description = "Nome completo do animal")
    private String nome;

    @Schema(description = "Peso do animal em gramas")
    private Integer peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
