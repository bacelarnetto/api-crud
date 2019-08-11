package br.com.api.test.resources;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.api.dto.CidadeFormDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class CidadeResourceTest {
	
	final String url = "http://localhost:";
	final int serverPort = 8080;
	final String baseUrl = url + serverPort + "/cidades";
	
	private Integer codigoCidade = 6;
	
	@Test
	public void test1GetCidadeListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();	    
	    
	    URI uri = new URI(baseUrl);

	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    
	    Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	    Assert.assertEquals(true, result.getBody().contains("SP"));
	}
	
	@Test
	public void test2PostNewCidadeSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		CidadeFormDTO cidade = new CidadeFormDTO("São Luís", "MA");
		HttpEntity<CidadeFormDTO> request = new HttpEntity<>(cidade);
		ResponseEntity<CidadeFormDTO> result = restTemplate
		  .exchange(baseUrl, HttpMethod.POST, request, CidadeFormDTO.class);
		  
		Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}
	
	@Test
	public void test3PutCidadeSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		CidadeFormDTO cidade = new CidadeFormDTO("Rio de Janeiro", "RJ");
		HttpEntity<CidadeFormDTO> request = new HttpEntity<>(cidade);
		String resourceUrl = baseUrl+"/"+codigoCidade;
		ResponseEntity<CidadeFormDTO> result = restTemplate
		  .exchange(resourceUrl, HttpMethod.PUT, request, CidadeFormDTO.class);		  
		Assert.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
	}
	
	@Test
	public void test4DeleteCidadeSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = baseUrl+"/"+getCodigoCidade();
		restTemplate.delete(resourceUrl);
	}


	public Integer getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

}
