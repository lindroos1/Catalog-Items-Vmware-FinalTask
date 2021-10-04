 package com.example.demo.services;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class CatalogItemsService {

	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private MultiValueMap<String, String> map;
	
	@Autowired
	public CatalogItemsService(RestTemplate restTemplate,  HttpHeaders headers,
			MultiValueMap<String, String> map){
		this.restTemplate = restTemplate;
		this.headers = headers;
		this.map = map;
	}
	
		//get auth token
		@ResponseBody
		public String getAuthToken() {
			 headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			 map.add("refresh_token", "JmPWxHtG3swG2kcenPoXj7ihABLLINs3JCNUz27nyxrMXViP4Tbrm0PBaToiA8Tf");
			 HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
			
			 ResponseEntity<String> response = restTemplate.postForEntity(
					  "https://console-stg.cloud.vmware.com/csp/gateway/am/api/auth/api-tokens/authorize",
					  request, String.class);
			 
		   // var authToken = new Gson().toJson(response, JsonObject.class);
			//authToken = new Gson().fromJson("access_token", null);
			return response.getBody();
		}
	
		
		//use the auth token to get the JSON
		@ResponseBody
		public String getCatalogItems() {
			var authToken = getAuthToken();
		   
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("Authorization", "Bearer" + authToken);

			HttpEntity<String> entity = new HttpEntity<>(" ", headers);

			//restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			return restTemplate.getForEntity("https://api.staging.symphony-dev.com/catalog/api/items",
					String.class, headers).getBody();
		}
		//return the JSON
}
