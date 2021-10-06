package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.HttpCustomEntity;

@SpringBootApplication
public class CatalogItemsVmwareFinalTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogItemsVmwareFinalTaskApplication.class, args);
	}
	
	 @Bean
	    public RestTemplate restTemplate() {
		  return new RestTemplate();
	    }
	 @Bean
	 public HttpHeaders httpHeaders() {
		 return new HttpHeaders();
	 }
	 

}
