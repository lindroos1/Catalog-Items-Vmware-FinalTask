package com.example.demo.entity;

import org.springframework.http.HttpEntity;

public interface HttpCustomEntity {

	public  HttpEntity<String> getEntity();
	public void setHeaders(HttpCustomHeaders customHeaders);
}
