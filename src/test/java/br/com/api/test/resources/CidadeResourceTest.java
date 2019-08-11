package br.com.api.test.resources;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
public class CidadeResourceTest {
	
	final String url = "http://localhost:";
	final int serverPort = 8080;
	final String baseUrl = url + serverPort + "/cidades";
	
	@Test
	public void test1GetCidadeListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();	    
	    
	    URI uri = new URI(baseUrl);

	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    
	    Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	    Assert.assertEquals(true, result.getBody().contains("SP"));
	}

}
