 package com.example.demo.services;


import java.util.Collections;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ejb.access.EjbAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.models.AuthentiactionToken;
import com.google.gson.JsonObject;

@Service
public class CatalogItemsService {

	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private AuthenticationTokenService authTokenService;
	
	@Autowired
	public CatalogItemsService(RestTemplate restTemplate, HttpHeaders headers,
			AuthenticationTokenService authTokenService) {
		this.restTemplate = restTemplate;
		this.headers = headers;
		this.authTokenService = authTokenService;
	}

	// get auth token
	

	// use the auth token to get the JSON
	@ResponseBody
	public String getCatalog(String url) throws RestClientException {
		var authToken = authTokenService.getAuthToken();

		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + authToken);

		HttpEntity<String> entity = new HttpEntity<>(headers);
		return restTemplate.exchange(url, HttpMethod.GET, entity,
				String.class).getBody();
	}
		//return the JSON
	

}
