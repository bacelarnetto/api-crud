package br.com.api.impl.integration;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.api.dto.CidadeDTO;
import br.com.api.dto.CidadeFormDTO;
import br.com.api.integration.CidadeIntegration;

@Service
public class CidadeIntegrationImpl implements CidadeIntegration {

	private final String baseUrl = "https://api-server-mock.herokuapp.com/cidades";

	public List<CidadeDTO> getCidades() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<CidadeDTO>> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CidadeDTO>>() {
				});
		return response.getBody();
	}

	public void insert(CidadeFormDTO cidade) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<CidadeFormDTO> request = new HttpEntity<>(cidade);
		restTemplate.exchange(baseUrl, HttpMethod.POST, request, CidadeFormDTO.class);
	}

	public void delete(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = baseUrl + "/" + id;
		restTemplate.delete(resourceUrl);
	}

	@Override
	public void update(Integer id, CidadeFormDTO cidade) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<CidadeFormDTO> request = new HttpEntity<>(cidade);
		String resourceUrl = baseUrl + "/" + id;
		restTemplate.exchange(resourceUrl, HttpMethod.PUT, request, CidadeFormDTO.class);

	}

}
