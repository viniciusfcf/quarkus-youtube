package com.github.viniciusfcf.crud;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Pessoa extends PanacheEntity {
    
    public String nome;

    public Integer idade;

    @OneToOne(cascade = CascadeType.ALL)
    public Endereco endereco;
}
