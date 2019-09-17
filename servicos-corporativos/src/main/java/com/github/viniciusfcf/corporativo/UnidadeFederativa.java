package com.github.viniciusfcf.corporativo;

import java.util.ArrayList;
import java.util.List;

public class UnidadeFederativa {

	private Integer id;
	
	private String sigla;
	
	private String nome;

	public UnidadeFederativa() {
		this(null, null, null);
	}
	
	public UnidadeFederativa(Integer id, String sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static List<UnidadeFederativa> getUfs() {
		ArrayList<UnidadeFederativa> ufs = new ArrayList<>();
		ufs.add(new UnidadeFederativa(1, "AL", "Alagoas"));
		ufs.add(new UnidadeFederativa(2, "DF", "Distrito Federal"));
		ufs.add(new UnidadeFederativa(3, "Pb", "Paraíba"));
		ufs.add(new UnidadeFederativa(4, "PE", "Pernambuco"));
		
		return ufs;
	}
}
