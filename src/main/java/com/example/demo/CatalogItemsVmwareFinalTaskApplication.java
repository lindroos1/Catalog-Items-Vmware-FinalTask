package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.models.AuthentiactionToken;

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
	
	 @Bean
	 public AuthentiactionToken authentiactionToken() {
		 return new AuthentiactionToken();
	 }
}
