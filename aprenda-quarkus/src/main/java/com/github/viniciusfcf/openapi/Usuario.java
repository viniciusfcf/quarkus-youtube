package com.github.viniciusfcf.openapi;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Usuario extends PanacheEntity {


    @Schema(description = "Nome completo do usuário")
    private String nome;

    @Schema(minimum = "0", exclusiveMinimum = true, description = "", required=true)
    private Long idade;

    @Schema(hidden = true)
    private LocalDateTime dataAtualizacaoDados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public LocalDateTime getDataAtualizacaoDados() {
        return dataAtualizacaoDados;
    }

    public void setDataAtualizacaoDados(LocalDateTime dataAtualizacaoDados) {
        this.dataAtualizacaoDados = dataAtualizacaoDados;
    }
}