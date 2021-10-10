package com.example.demo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;


import com.example.demo.services.CatalogItemsService;
import com.example.models.CatalogItems;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class Controller {

	@Autowired
	CatalogItemsService s;
	
	@GetMapping("/getAllItems")
	public List<CatalogItems> getItems() throws RestClientException {
		 String url = "https://api.staging.symphony-dev.com/catalog/api/items";
		 return s.getCatalog(url).getContent();
	}
			
	@GetMapping("getSpecificItem")
	public CatalogItems getSpecificItem(@RequestParam String itemId) {
		String url = "https://api.staging.symphony-dev.com/catalog/api/items/" + itemId;
		return  s.getSingleCatalog(url);
	}
	
	@PostMapping("/postItem")
	public String postItem(@RequestBody CatalogItems catalogItems) throws RestClientException{
		String url = "https://api.staging.symphony-dev.com/catalog/api/items/" + catalogItems.getId() +
				"/request";
		return s.postCatalogItems(url, catalogItems);
	}

}
