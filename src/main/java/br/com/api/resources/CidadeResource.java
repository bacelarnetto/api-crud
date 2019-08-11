package br.com.api.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.CidadeDTO;
import br.com.api.dto.CidadeFormDTO;
import br.com.api.integration.CidadeIntegration;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeIntegration cidadeIntegration;
	
	@ApiOperation(value="Buscar a lista com todas as Cidades de uma API externa")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findAll() {
		List<CidadeDTO> listDTO = cidadeIntegration.getCidades();
		return ResponseEntity.ok().body(listDTO);
	}
	
	@ApiOperation(value="Cadastrar uma Cidade de uma API externa")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CidadeFormDTO dto) {
		cidadeIntegration.insert(dto);
		return ResponseEntity.created(null).build();
	}
	
	@ApiOperation(value="Excluir uma Cidade por id de uma API externa")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		cidadeIntegration.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Atualizar uma Cidade por id de uma API externa")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @PathVariable Integer id, @RequestBody CidadeFormDTO dto) {
		cidadeIntegration.update(id, dto);
		return ResponseEntity.noContent().build();
	}

}
