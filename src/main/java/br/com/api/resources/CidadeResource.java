package br.com.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.CidadeDTO;
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

}
