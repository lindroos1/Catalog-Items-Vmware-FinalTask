package com.example.demo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;


import com.example.demo.services.CatalogItemsService;
import com.example.models.CatalogItems;
import com.example.models.CatalogItemsList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class Controller {

	@Autowired
	CatalogItemsService s;
	
	@GetMapping("/getAllItems")
	public CatalogItemsList getItems() throws RestClientException {
		 String url = "https://api.staging.symphony-dev.com/catalog/api/items";
		 return s.getCatalog(url);
	}
			
	@GetMapping("getSpecificItem")
	public CatalogItems getSpecificItem(@RequestParam String itemId) {
		String url = "https://api.staging.symphony-dev.com/catalog/api/items/" + itemId;
		return  s.getSingleCatalog(url);
	}

}
