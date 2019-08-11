package br.com.api.integration;

import java.util.List;

import br.com.api.dto.CidadeDTO;

public interface CidadeIntegration {
	
	/**
	 * Busca lista de cidades da api externa de cidades
	 * 
	 * @return List<CidadeDTO>
	 * 
	 */
	List<CidadeDTO> getCidades();

}
