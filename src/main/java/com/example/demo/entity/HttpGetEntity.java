package com.example.demo.entity;

import org.springframework.http.HttpEntity;

public class HttpGetEntity implements HttpCustomEntity {
	
	private HttpEntity<String> entity;
	@Override
	public HttpEntity<String> getEntity() {
		return entity;
	}

	@Override
	public void setHeaders(HttpCustomHeaders customHeaders) {
		entity = new HttpEntity<String>(customHeaders.getHeaders());
	}

}
