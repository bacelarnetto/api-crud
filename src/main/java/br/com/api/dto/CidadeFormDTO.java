package br.com.api.dto;

import java.io.Serializable;

public class CidadeFormDTO implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String uf;
	
	public CidadeFormDTO() {
		super();
	}

	public CidadeFormDTO(String name, String uf) {
		super();
		this.name = name;
		this.uf = uf;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


}
