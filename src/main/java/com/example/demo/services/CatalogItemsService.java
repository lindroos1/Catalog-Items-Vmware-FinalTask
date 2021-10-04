 package com.example.demo.services;


import java.util.Collections;

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
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ch.qos.logback.classic.Logger;

@Service
public class CatalogItemsService {

	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private MultiValueMap<String, String> map;
	AuthentiactionToken authentiactionToken;

	@Autowired
	public CatalogItemsService(RestTemplate restTemplate, HttpHeaders headers, MultiValueMap<String, String> map,
			AuthentiactionToken authentiactionToken) {
		this.restTemplate = restTemplate;
		this.headers = headers;
		this.map = map;
		this.authentiactionToken = authentiactionToken;
	}

	// get auth token
	@ResponseBody
	private String getAuthToken() throws  RestClientException{

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		map.add("refresh_token", "JmPWxHtG3swG2kcenPoXj7ihABLLINs3JCNUz27nyxrMXViP4Tbrm0PBaToiA8Tf");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		authentiactionToken = restTemplate.postForObject(
				"https://console-stg.cloud.vmware.com/csp/gateway/am/api/auth/api-tokens/authorize", request,
				AuthentiactionToken.class);
		return authentiactionToken.getAccess_token();
	}

	// use the auth token to get the JSON
	@ResponseBody
	public String getCatalogItems() throws RestClientException {
		var authToken = getAuthToken();

		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + authToken);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange("https://api.staging.symphony-dev.com/catalog/api/items", HttpMethod.GET, entity,
				String.class).getBody();
	}
		//return the JSON
}
