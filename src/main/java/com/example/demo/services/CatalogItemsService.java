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
import com.example.helpers.JsonInputHelper;
import com.example.models.CatalogItems;
import com.example.models.CatalogItemsList;
import com.example.models.Schema;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class CatalogItemsService {

	private RestTemplate restTemplate;
	private HttpCustomHeaders customHeaders;
	private HttpGetEntity getEntity;
	private HttpPostEntity postEntity;
	private Schema schema = new Schema();
	
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
		getEntity.setHeaders(customHeaders);
		  var ans = restTemplate.exchange(url, HttpMethod.GET, getEntity.getEntity(),
				CatalogItems.class).getBody();
		  
		  
		  int len = ans.getSchema().getRequired().length;
		  String[] str = new String[len];
		  this.schema.setRequired(str);
		  
		 for(int c = 0; c < ans.getSchema().getRequired().length; c++) {
			this.schema.getRequired()[c] = ans.getSchema().getRequired()[c];
		 }
		 
		 String[] possibleInputs ={"array", "integer", "number", "object", "string", "boolean", "password"};
		 if(ans.getSchema().getRequired().length>0) {
			 for(int i = 0; i < ans.getSchema().getRequired().length; i++) {
				 for(int b = 0; b < possibleInputs.length; b++) {
					 if(ans.getSchema().getRequired()[i].toLowerCase().contains(possibleInputs[b])) {
						 var newValue = possibleInputs[b];
						 ans.getSchema().getRequired()[i] = newValue;
					 }
				 }
				
			 }
		 }
		
		 return ans;
	}	
	@ResponseBody
	public String postCatalogItems(String url, CatalogItems catalogItems) throws RestClientException{
				JsonInputHelper jsonInputHelper = new JsonInputHelper(catalogItems.getInput(),
						catalogItems, schema);
				postEntity.setHeaders(customHeaders);
				
				JsonObject body = new JsonObject();
				body.addProperty("bulkRequestCount",1);
				body.addProperty("deploymentName",catalogItems.getInput().getDeploymentName());
				body.add("inputs", jsonInputHelper.getJsonInput());
				body.addProperty("projectId", catalogItems.getProjectIds()[0]);
				body.addProperty("reason","");
				body.addProperty("version","");
				postEntity.setBody(body);
				
			return restTemplate.exchange(url, HttpMethod.POST, postEntity.getEntity(),
				String.class).getBody();
	}
	
}
