 package com.example.demo.services;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.HttpCustomHeaders;
import com.example.demo.entity.HttpGetEntity;
import com.example.demo.entity.HttpPostEntity;
import com.example.helpers.SetVersionsHelper;
import com.example.models.catalogItems.CatalogItems;
import com.example.models.catalogItems.CatalogItemsList;
import com.example.models.catalogItems.VersionsList;
import com.example.models.deployments.Deployment;
import com.example.models.deployments.DeploymentsList;
import com.google.gson.JsonObject;

@Service
public class CatalogItemsService {

	private RestTemplate restTemplate;
	private HttpCustomHeaders customHeaders;
	private HttpGetEntity getEntity;
	
	@Autowired
	public CatalogItemsService(RestTemplate restTemplate, HttpCustomHeaders customHeaders,
			HttpGetEntity getEntity) {
		this.restTemplate = restTemplate;
		this.customHeaders = customHeaders;
		this.getEntity = getEntity;
	}

	@ResponseBody
	public CatalogItemsList getCatalog(String url) throws RestClientException {
		getEntity.setHeaders(customHeaders);
		CatalogItemsList catalogitemList =  restTemplate.exchange(url, HttpMethod.GET, getEntity.getEntity(),
				CatalogItemsList.class).getBody();
		
		SetVersionsHelper.setVersions(catalogitemList, restTemplate, getEntity);
		return catalogitemList;
	}
	
	
	@ResponseBody
	public ResponseEntity<String> getimage(String url) {
		getEntity.setHeaders(customHeaders);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.valueOf("image/svg+xml"));
	    var exchange = restTemplate.exchange(url, HttpMethod.GET, getEntity.getEntity(), String.class).getBody();
		return  new ResponseEntity<String>( exchange, headers, HttpStatus.OK);
	}
	
	
}
