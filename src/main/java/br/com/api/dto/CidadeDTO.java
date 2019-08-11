package br.com.api.dto;

import java.io.Serializable;

public class CidadeDTO implements Serializable {
		
	private static final long serialVersionUID = 1L;	
	
	private String name;
	private String uf;
	private Integer id;
	
	public CidadeDTO() {
		super();
	}

	public CidadeDTO(String name, String uf, Integer id) {
		super();
		this.name = name;
		this.uf = uf;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
