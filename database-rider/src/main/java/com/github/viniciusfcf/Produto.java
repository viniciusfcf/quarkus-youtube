package com.github.viniciusfcf;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name="PRODUTO")
public class Produto extends PanacheEntity {
    
    public String nome;

    public String descricao;

    public Double peso;
}