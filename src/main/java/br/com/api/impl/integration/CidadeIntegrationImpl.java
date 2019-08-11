package br.com.api.impl.integration;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.api.dto.CidadeDTO;
import br.com.api.integration.CidadeIntegration;

@Service
public class CidadeIntegrationImpl implements CidadeIntegration{

	@SuppressWarnings("unchecked")
	public List<CidadeDTO> getCidades() {

		List<CidadeDTO> cidades = null;
		try {
			URL url = new URL("https://api-server-mock.herokuapp.com/cidades");
			
			ObjectMapper mapper = new ObjectMapper();
			
			cidades = mapper.readValue(url, List.class);

			return cidades;

		} catch (IOException i1) {
			i1.printStackTrace();
		}
		return cidades;
	}

}
