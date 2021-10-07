package com.example.demo.entity;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import com.google.gson.JsonObject;

public class HttpPostEntity  implements HttpCustomEntity{

	private HttpEntity<String> entity;
	private HttpHeaders headers;
	@Override
	public HttpEntity<String> getEntity() {
		return entity;
	}
	
	public void setBody(JsonObject object) {
		entity = new HttpEntity<>(object.toString(), headers);
	}

	@Override
	public void setHeaders(HttpCustomHeaders customHeaders) {
		headers = customHeaders.getHeaders();
	}

}
