 package com.example.demo.services;



import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.HttpCustomHeaders;
import com.example.demo.entity.HttpGetEntity;
import com.example.demo.entity.HttpPostEntity;
import com.example.models.CatalogItems;
import com.example.models.CatalogItemsList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class CatalogItemsService {

	private RestTemplate restTemplate;
	private HttpCustomHeaders customHeaders;
	private HttpGetEntity getEntity;
	private HttpPostEntity postEntity;
	
	@Autowired
	public CatalogItemsService(RestTemplate restTemplate, HttpCustomHeaders customHeaders,
			HttpGetEntity getEntity, HttpPostEntity postEntity) {
		this.restTemplate = restTemplate;
		this.customHeaders = customHeaders;
		this.getEntity = getEntity;
		this.postEntity = postEntity;
	}

	@ResponseBody
	public CatalogItemsList getCatalog(String url) throws RestClientException {
		getEntity.setHeaders(customHeaders);
		return restTemplate.exchange(url, HttpMethod.GET, getEntity.getEntity(),
				CatalogItemsList.class).getBody();
	}
	
	@ResponseBody
	public CatalogItems getSingleCatalog(String url) throws RestClientException {
			
		
		return restTemplate.exchange(url, HttpMethod.GET, getEntity.getEntity(),
				CatalogItems.class).getBody();
	}
	
	@ResponseBody
	public String PostCatalogItems(String url, String projectId) throws RestClientException {
		
				JsonObject object = new JsonObject();
				JsonObject object1 = new JsonObject();
				object.addProperty("bulkRequestCount",1);
				object.addProperty("deploymentName","send from Spring");
				object.add("inputs", object1);
				object.addProperty("projectId", projectId);
				object.addProperty("reason", "");
				object.addProperty("version", "");
				
				postEntity.setHeaders(customHeaders);
				postEntity.setBody(object);
				
			return restTemplate.exchange(url, HttpMethod.POST, postEntity.getEntity(),
				String.class).getBody();
	}
	
}
