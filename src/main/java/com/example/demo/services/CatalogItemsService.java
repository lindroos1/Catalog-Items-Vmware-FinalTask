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

import com.example.demo.entity.HttpCustomEntity;
import com.example.models.CatalogItems;
import com.example.models.CatalogItemsList;

@Service
public class CatalogItemsService {

	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private HttpCustomEntity customEntity;
	
	@Autowired
	public CatalogItemsService(RestTemplate restTemplate, HttpHeaders headers,
			HttpCustomEntity customEntity) {
		this.restTemplate = restTemplate;
		this.headers = headers;
		this.customEntity = customEntity;
	}

	@ResponseBody
	public CatalogItemsList getCatalog(String url) throws RestClientException {

		return restTemplate.exchange(url, HttpMethod.GET, customEntity.getEntity(),
				CatalogItemsList.class).getBody();
	}
	
	@ResponseBody
	public CatalogItems getSingleCatalog(String url) throws RestClientException {

		
		return restTemplate.exchange(url, HttpMethod.GET, customEntity.getEntity(),
				CatalogItems.class).getBody();
	}
}
