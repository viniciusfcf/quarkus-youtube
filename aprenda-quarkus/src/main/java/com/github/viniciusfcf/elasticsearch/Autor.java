package com.github.viniciusfcf.elasticsearch;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
// @Indexed COMENTADO NO VIDEO 16
public class Autor extends PanacheEntity{

	//name default é o nome do atributo
	//COMENTADO NO VIDEO 16
    // @FullTextField(analyzer = "string_generica") 
    // @KeywordField(name = "nome_sort", sortable = Sortable.YES, normalizer = "sort_string_generica") 
    private String nome;

    private String sobrenomes;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	//COMENTADO NO VIDEO 16
	// @IndexedEmbedded(storage = ObjectFieldStorage.DEFAULT)
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
