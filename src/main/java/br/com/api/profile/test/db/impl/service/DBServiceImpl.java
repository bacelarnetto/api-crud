package br.com.api.profile.test.db.impl.service;
import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.domain.Pessoa;
import br.com.api.profile.test.db.service.DBService;
import br.com.api.repository.PessoaRepository;


@Service
public class DBServiceImpl implements DBService{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public void instantiateTestDatabase() throws ParseException {		
		
		Pessoa p1 = new Pessoa(null, "Maria Silva", "maria@mail.com", 26, 62, "1.64");		
		Pessoa p2 = new Pessoa(null, "Jose", "jose@mail.com", 34, 90, "1.81");
		Pessoa p3 = new Pessoa(null, "Luiza", "luiza@mail.com", 18, 58, "1.62");
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}