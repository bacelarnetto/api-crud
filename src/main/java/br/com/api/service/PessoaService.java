package br.com.api.service;

import java.util.List;

import br.com.api.domain.Pessoa;
import br.com.api.dto.PessoaDTO;
import br.com.api.dto.PessoaNewDTO;



public interface PessoaService {
	
	Pessoa find(Integer id);
	
	Pessoa insert(Pessoa pessoa);

	Pessoa update(Pessoa pessoa);

	void delete(Integer id);

	List<Pessoa> findAll();
	
	Pessoa fromTO(PessoaNewDTO dto);
	
	Pessoa fromTO(PessoaDTO dto);

}
