package com.github.viniciusfcf.elasticsearch;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.search.engine.backend.document.model.dsl.ObjectFieldStorage;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Indexed
public class Autor extends PanacheEntity{

	//name default é o nome do atributo
    @FullTextField(analyzer = "string_generica") 
    @KeywordField(name = "nome_sort", sortable = Sortable.YES, normalizer = "sort_string_generica") 
    private String nome;

    private String sobrenomes;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@IndexedEmbedded(storage = ObjectFieldStorage.DEFAULT)
    private List<Livro> livros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenomes() {
		return sobrenomes;
	}

	public void setSobrenomes(String sobrenomes) {
		this.sobrenomes = sobrenomes;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
