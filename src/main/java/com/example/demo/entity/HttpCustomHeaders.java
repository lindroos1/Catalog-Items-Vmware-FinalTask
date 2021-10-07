package com.example.demo.entity;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.example.demo.services.AuthenticationTokenService;

@Component
public class HttpCustomHeaders {

	private String authToken;
	private HttpHeaders headers;
	
	@Autowired
	private HttpCustomHeaders(HttpHeaders headers,
			AuthenticationTokenService authTokenService) {
		this.headers = headers;
		this.authToken = authTokenService.getAuthToken();
		
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + authToken);

	}
	

	public HttpHeaders getHeaders() {
		return this.headers;
	}
}
