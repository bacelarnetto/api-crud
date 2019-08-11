package br.com.api.dto;

import java.io.Serializable;

public class CidadeFormDTO implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String uf;
	
	public CidadeFormDTO() {
		super();
	}

	public CidadeFormDTO(String nome, String uf) {
		super();
		this.nome = nome;
		this.uf = uf;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


}
