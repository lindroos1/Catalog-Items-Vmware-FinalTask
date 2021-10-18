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
import com.example.models.CatalogItems;
import com.example.models.CatalogItemsList;
import com.example.models.Deployment;
import com.example.models.DeploymentsList;
import com.example.models.VersionsList;
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
		CatalogItemsList catalogitemList =  restTemplate.exchange(url, HttpMethod.GET, getEntity.getEntity(),
				CatalogItemsList.class).getBody();
		
		for(int i = 0; i < catalogitemList.getContent().size(); i++) {
			String urrl = "https://api.staging.symphony-dev.com/catalog/api/items/" +
					catalogitemList.getContent().get(i).getId()+ "/versions";
			catalogitemList.getContent().get(i).setVersions(restTemplate.exchange(urrl, HttpMethod.GET ,getEntity.getEntity(),
					VersionsList.class).getBody());
		}
		
		return catalogitemList;
	}
	
	@ResponseBody
	public CatalogItems getSingleCatalog(String url) throws RestClientException {
		getEntity.setHeaders(customHeaders);
		  var ans = restTemplate.exchange(url, HttpMethod.GET, getEntity.getEntity(),
				CatalogItems.class).getBody();
		  
		  
		 return ans;
	}	
	
	
	@ResponseBody
	public String postCatalogItems(String url, CatalogItems catalogItems) throws RestClientException{
		/*
		 * JsonInputHelper jsonInputHelper = new
		 * JsonInputHelper(catalogItems.getInput(), catalogItems, schema);
		 * postEntity.setHeaders(customHeaders);
		 * 
		 * JsonObject body = new JsonObject(); body.addProperty("bulkRequestCount",1);
		 * body.addProperty("deploymentName",catalogItems.getInput().getDeploymentName()
		 * ); body.add("inputs", jsonInputHelper.getJsonInput());
		 * body.addProperty("projectId", catalogItems.getProjectIds()[0]);
		 * body.addProperty("reason",""); body.addProperty("version","");
		 * postEntity.setBody(body);
		 * 
		 * return restTemplate.exchange(url, HttpMethod.POST, postEntity.getEntity(),
		 * String.class).getBody();
		 */
		return "whatever"; 
	}
	
	@ResponseBody
	public ResponseEntity<String> getimage(String url) {
		getEntity.setHeaders(customHeaders);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.valueOf("image/svg+xml"));
	    var exchange = restTemplate.exchange(url, HttpMethod.GET, getEntity.getEntity(), String.class).getBody();
		return  new ResponseEntity<String>( exchange, headers, HttpStatus.OK);
	}
	
	public DeploymentsList getDeployment(String url ) {
		getEntity.setHeaders(customHeaders);
		return restTemplate.exchange(url, HttpMethod.GET ,getEntity.getEntity(),
				DeploymentsList.class).getBody();
	}
	
}
