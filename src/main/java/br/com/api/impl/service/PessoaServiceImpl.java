package br.com.api.impl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.domain.Pessoa;
import br.com.api.dto.PessoaDTO;
import br.com.api.dto.PessoaNewDTO;
import br.com.api.exception.DataIntegrityException;
import br.com.api.exception.ObjectNotFoundException;
import br.com.api.repository.PessoaRepository;
import br.com.api.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa find(Integer id) {

		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
	}

	@Transactional
	public Pessoa insert(Pessoa pessoa) {
		pessoa.setId(null);
		pessoa = repo.save(pessoa);
		return pessoa;
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		Pessoa newPessoa = find(pessoa.getId());
		updateData(newPessoa, pessoa);
		return repo.save(newPessoa);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	public List<Pessoa> findAll() {
		return repo.findAll();
	}

	private void updateData(Pessoa newPessoa, Pessoa pessoa) {
		newPessoa.setNome(pessoa.getNome());
		newPessoa.setEmail(pessoa.getEmail());
		newPessoa.setAltura(pessoa.getAltura());
		newPessoa.setPeso(pessoa.getPeso());
		newPessoa.setIdade(pessoa.getIdade());
	}

	public Pessoa fromTO(PessoaNewDTO dto) {
		return new Pessoa(null, dto.getNome(), dto.getEmail(), dto.getIdade(), dto.getPeso(), dto.getAltura());
	}

	public Pessoa fromTO(PessoaDTO dto) {
		return new Pessoa(dto.getId(), dto.getNome(), dto.getEmail(), dto.getIdade(), dto.getPeso(), dto.getAltura());
	}

}
