 package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


public class GetCatalogItemsService {

		//get auth token
		public void getAuthToken(RestTemplate restTemplate, HttpHeaders headers, MultiValueMap<String, String> map) {
			 headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			 map.add("refresh_token", "JmPWxHtG3swG2kcenPoXj7ihABLLINs3JCNUz27nyxrMXViP4Tbrm0PBaToiA8Tf");
			 HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
			
			 ResponseEntity<String> response = restTemplate.postForEntity(
					  "https://console-stg.cloud.vmware.com/csp/gateway/am/api/auth/api-tokens/authorize",
					  request, String.class);
			 
			response.getBody();
		}
	
		/*
		//use the auth token to get the JSON
		public String getCatalogItems() {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("Authorization", null);

			HttpEntity<String> entity = new HttpEntity<>("body", headers);

			restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		}
		//return the JSON
		 */
}
