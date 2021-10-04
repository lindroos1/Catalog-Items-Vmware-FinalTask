package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.example.demo.services.CatalogItemsService;
@RestController
public class Controller {

	@Autowired
	CatalogItemsService s;
	
	@GetMapping("/")
	public String getItems() throws RestClientException {
		 return s.getCatalogItems();
	}
}
