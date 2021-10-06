package com.example.demo.entity;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.example.demo.services.AuthenticationTokenService;

@Component
public class HttpCustomEntity {

	private static HttpEntity<String> entity;
	private String authToken;
	
	@Autowired
	private HttpCustomEntity(HttpHeaders headers,
			AuthenticationTokenService authTokenService) {
		this.authToken = authTokenService.getAuthToken();
		
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + authToken);

		 entity = new HttpEntity<>(headers);
	}
	
	public static HttpEntity<String> getEntity(){
		return entity;
	}
}
