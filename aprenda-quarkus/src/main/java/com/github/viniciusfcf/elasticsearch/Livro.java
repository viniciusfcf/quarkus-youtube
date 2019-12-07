package com.github.viniciusfcf.elasticsearch;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
// @Indexed
public class Livro extends PanacheEntity {
    
    //COMENTADO NO VIDEO 16
    // @FullTextField(analyzer = "string_generica") 
    private String titulo;
    //COMENTADO NO VIDEO 16
    // @FullTextField(analyzer = "string_generica") 
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