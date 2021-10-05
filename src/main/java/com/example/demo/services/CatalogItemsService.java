 package com.example.demo.services;



import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.models.AuthentiactionToken;
import com.example.models.CatalogItems;
import com.example.models.CatalogItemsList;

@Service
public class CatalogItemsService {

	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private String authToken;
	
	@Autowired
	public CatalogItemsService(RestTemplate restTemplate, HttpHeaders headers,
			AuthenticationTokenService authTokenService) {
		this.restTemplate = restTemplate;
		this.headers = headers;
		this.authToken = authTokenService.getAuthToken();
	}

	@ResponseBody
	public CatalogItemsList getCatalog(String url) throws RestClientException {

		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + authToken);

		HttpEntity<String> entity = new HttpEntity<>(headers);
		return restTemplate.exchange(url, HttpMethod.GET, entity,
				CatalogItemsList.class).getBody();
	}
	
	@ResponseBody
	public CatalogItems getSingleCatalog(String url) throws RestClientException {

		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + authToken);

		HttpEntity<String> entity = new HttpEntity<>(headers);
		return restTemplate.exchange(url, HttpMethod.GET, entity,
				CatalogItems.class).getBody();
	}
}
