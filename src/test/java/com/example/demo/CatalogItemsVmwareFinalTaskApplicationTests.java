package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.controllers.Controller;
import com.example.demo.services.AuthenticationTokenService;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CatalogItemsVmwareFinalTaskApplicationTests {

	@Autowired
	private Controller controller;

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired 
	private AuthenticationTokenService autoService;
	
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	

	@Test
	public void shouldReturnAllItems() throws Exception {
		var obj = this.restTemplate.getForEntity("http://localhost:" + port + "/getAllItems",
				String.class);
		assertThat(obj.getStatusCode().equals(HttpStatus.OK));
	}
	
	@Test
	public void shouldReturnAllDeployments() {
		var obj = this.restTemplate.getForEntity("http://localhost:" + port + "/getDeployments",
				String.class);
		assertThat(obj.getStatusCode().equals(HttpStatus.OK));
	}
	
	@Test
	public void shouldReturnImage() {
		assertThat(this.restTemplate.getForEntity("http://localhost:" + port + "/getimage",
				String.class).equals(HttpStatus.OK));
	}
	
	@Test
	public void shouldReturnToken() {
		assertThat(this.autoService.getAuthToken()).isNotEmpty();
	}
	

}

