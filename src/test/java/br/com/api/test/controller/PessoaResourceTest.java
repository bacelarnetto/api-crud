package br.com.api.test.controller;

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

import br.com.api.domain.Pessoa;
import br.com.api.dto.PessoaDTO;
import br.com.api.dto.PessoaNewDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class PessoaResourceTest {

	final String url = "http://localhost:";
	final int serverPort = 8080;
	final String baseUrl = url + serverPort + "/pessoas";
	
	private Integer codigoPessoa = 4;

	@Test
	public void test1GetPessoaListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();	    
	    
	    URI uri = new URI(baseUrl);

	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    
	    Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	    Assert.assertEquals(true, result.getBody().contains("Jose"));
	}
	
	@Test
	public void test2PostNewPessoaSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		PessoaNewDTO pessoa = new PessoaNewDTO("Beto Silva", "beto@mail.com", 29, 85, "1.78");
		HttpEntity<PessoaNewDTO> request = new HttpEntity<>(pessoa);
		ResponseEntity<PessoaNewDTO> result = restTemplate
		  .exchange(baseUrl, HttpMethod.POST, request, PessoaNewDTO.class);
		  
		Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}
	
	@Test
	public void test3PutPessoaSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		PessoaDTO pessoa = new PessoaDTO(codigoPessoa, "Beto Silva", "beto@mail.com", 30, 85, "1.78");
		HttpEntity<PessoaDTO> request = new HttpEntity<>(pessoa);
		String resourceUrl = baseUrl+"/"+pessoa.getId();
		ResponseEntity<PessoaNewDTO> result = restTemplate
		  .exchange(resourceUrl, HttpMethod.PUT, request, PessoaNewDTO.class);
		
		Pessoa p = getPessoa(pessoa.getId());
		
		Assert.assertEquals(true, pessoa.getIdade().equals(p.getIdade()));
		  
		Assert.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
	}
	
	@Test
	public void test4DeletePessoaSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = baseUrl+"/"+codigoPessoa;
		restTemplate.delete(resourceUrl);
	}
	
	
	private Pessoa getPessoa(Integer codigo) throws URISyntaxException { 
		
		RestTemplate restTemplate = new RestTemplate();	    
	    
	    URI uri = new URI(baseUrl +"/"+ codigo);

	    ResponseEntity<Pessoa> result = restTemplate.getForEntity(uri, Pessoa.class);
	    	   
	    Pessoa pessoa = null;	   
	    
	    if(HttpStatus.OK.equals(result.getStatusCode()) && result != null ) {
	    	pessoa = result.getBody();
	    }
		
		return pessoa;
	}

	public Integer getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(Integer codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

}
