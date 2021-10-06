
  package com.example.demo.services;

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
import com.google.gson.JsonObject;

@Service
public class AuthenticationTokenService {
	private RestTemplate restTemplate;
	private HttpHeaders headers;
	
	@Autowired
	 public AuthenticationTokenService(RestTemplate restTemplate, HttpHeaders headers) {
		this.headers = headers;
		this.restTemplate = restTemplate;
	}
	  
	  @ResponseBody
		public String getAuthToken() throws  RestClientException{
			headers.setContentType(MediaType.APPLICATION_JSON);
			JsonObject j = new JsonObject();
			j.addProperty("refreshToken", "JmPWxHtG3swG2kcenPoXj7ihABLLINs3JCNUz27nyxrMXViP4Tbrm0PBaToiA8Tf");
			HttpEntity<String> request = new HttpEntity<>(j.toString(), headers);

			 return restTemplate.exchange("https://api.staging.symphony-dev.com/iaas/api/login",
				HttpMethod.POST, request,
				AuthentiactionToken.class).getBody().getToken();
		}

  }
 