package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.example.demo.services.CatalogItemsService;
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
	
	@GetMapping("/")
	public String test() {
		return s.getAuthToken();
	}
}
