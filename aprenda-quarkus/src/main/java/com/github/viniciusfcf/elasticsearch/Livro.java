package com.github.viniciusfcf.elasticsearch;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.search.engine.backend.document.model.dsl.ObjectFieldStorage;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Indexed
public class Livro extends PanacheEntity {

    @FullTextField(analyzer = "string_generica") 
    private String titulo;

    @FullTextField(analyzer = "string_generica") 
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "autor", referencedColumnName = "id")
    //Evita loop infinito na serializacao. SEMPRE colocar em mapeamentos bidirecionais
    @JsonbTransient
    private Autor autor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}