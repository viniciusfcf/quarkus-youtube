package com.github.viniciusfcf.junit;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Animal extends PanacheEntity {

    private String nome;

    private Integer peso;

    public Animal(String nome, Integer peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public Animal() {
        this(null, null);
    }

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