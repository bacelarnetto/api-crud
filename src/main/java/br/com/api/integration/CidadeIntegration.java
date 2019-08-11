package br.com.api.integration;

import java.util.List;

import br.com.api.dto.CidadeDTO;
import br.com.api.dto.CidadeFormDTO;

public interface CidadeIntegration {
	
	/**
	 * Busca lista de cidades da api externa
	 * 
	 * @return List<CidadeDTO>
	 * 
	 */
	List<CidadeDTO> getCidades();
	
	/**
	 * Cadastra cidade na api externa
	 * 
	 * @param cidade
	 *
	 */
	void insert(CidadeFormDTO cidade);

	/**
	 * Excluir cidade por id na api externa
	 * 
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * Altera cidade na api externa
	 * 
	 * @param id
	 * @param cidade
	 *
	 */
	void update(Integer id, CidadeFormDTO cidade);
}
