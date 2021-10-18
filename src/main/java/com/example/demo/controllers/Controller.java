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
import com.example.models.CatalogItems;
import com.example.models.Deployment;
import com.example.models.DeploymentsList;
import com.example.models.Versions;

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
	
	@GetMapping("getImage")
	public ResponseEntity<String> getImage(@RequestParam String imageId) {
		String url = "https://api.staging.symphony-dev.com/icon/api/icons/" + imageId;
		return s.getimage(url);
		 //return svgEntity;
	}

	@GetMapping("getDeployments")
	public List<Deployment> getDeployments() {
		String url = "https://api.staging.symphony-dev.com/deployment/api/deployments";
		//returning it with .getContent witch means it will return what's inside the "content":
		//as a List<Deployments => Spring will send what's inside "content": without the wrapper
		//that way it will be easier for mapping in the Front
		return s.getDeployment(url).getContent();
	}
	
	@GetMapping("GetVersions")
	public List<Versions> getVersions(@RequestParam String id){
		String url = "https://api.staging.symphony-dev.com/catalog/api/items/" + id + "/versions";
		return s.getVersions(url).getContent();
	}

}
