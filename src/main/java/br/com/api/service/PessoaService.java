package br.com.api.service;

import java.util.List;

import br.com.api.domain.Pessoa;
import br.com.api.dto.PessoaDTO;
import br.com.api.dto.PessoaNewDTO;


public interface PessoaService {
	
	/**
	 * Busca pessoa
	 * 
	 * @param id
	 * 
	 * @return Pessoa
	 */
	Pessoa find(Integer id);
	
	/**
	 * Cadastra pessoa
	 * 
	 * @param pessoa
	 * 
	 * @return Pessoa
	 */
	Pessoa insert(Pessoa pessoa);

	/**
	 * Atualiza pessoa
	 * 
	 * @param pessoa
	 * 
	 * @return Pessoa
	 */
	Pessoa update(Pessoa pessoa);

	/**
	 * Excluir pessoa
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * Busca todas as pessoas
	 * 
	 * @return List<Pessoa>
	 */
	List<Pessoa> findAll();
	
	/**
	 * @param dto
	 * 
	 * @return Pessoa
	 */
	Pessoa fromTO(PessoaNewDTO dto);
	
	/**
	 * @param dto
	 * 
	 * @return Pessoa
	 */
	Pessoa fromTO(PessoaDTO dto);

}
