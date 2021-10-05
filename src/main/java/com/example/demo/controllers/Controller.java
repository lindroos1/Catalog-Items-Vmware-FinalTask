package com.example.demo.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.services.CatalogItemsService;
import com.example.models.AuthentiactionToken;
@RestController
public class Controller {

	@Autowired
	CatalogItemsService s;
	
	@GetMapping("/getAllItems")
	public String getItems() throws RestClientException {
		 String url = "https://api.staging.symphony-dev.com/catalog/api/items";
		 return s.getCatalog(url);
	}
		
	@GetMapping("getSpecificItem")
	public String getSpecificItem(@RequestParam String itemId) {
		String url = "https://api.staging.symphony-dev.com/catalog/api/items/" + itemId;
		return s.getCatalog(url);
	}
	
}
