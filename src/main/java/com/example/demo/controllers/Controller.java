package com.example.demo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;


import com.example.demo.services.CatalogItemsService;
import com.example.models.catalogItems.CatalogItems;
import com.example.models.catalogItems.Versions;
import com.example.models.deployments.Deployment;
import com.example.models.deployments.DeploymentsList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class Controller {

	@Autowired
	CatalogItemsService s;
	
	@GetMapping("/getAllItems")
	public List<CatalogItems> getItems() throws RestClientException {
		 String url = "https://api.staging.symphony-dev.com/catalog/api/items?expandProjects=true";
		 return s.getCatalog(url).getContent();
	}
			
	
	@GetMapping("getImage")
	public ResponseEntity<String> getImage(@RequestParam String imageId) {
		String url = "https://api.staging.symphony-dev.com/icon/api/icons/" + imageId;
		return s.getimage(url);
	}

}
