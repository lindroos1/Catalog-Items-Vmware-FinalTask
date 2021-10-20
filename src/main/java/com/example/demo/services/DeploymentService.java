package com.example.demo.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.HttpCustomHeaders;
import com.example.demo.entity.HttpGetEntity;
import com.example.demo.entity.HttpPostEntity;
import com.example.models.deployments.Deployment;
import com.example.models.deployments.DeploymentsList;
import com.example.models.deployments.NoInputDeployment;
import com.google.gson.JsonObject;


@Service
public class DeploymentService {

	private RestTemplate restTemplate;
	private HttpCustomHeaders customHeaders;
	private HttpGetEntity getEntity;
	private HttpPostEntity postEntity;
	
	public DeploymentService(RestTemplate restTemplate, HttpCustomHeaders customHeaders,
			HttpGetEntity getEntity, HttpPostEntity postEntity) {
		this.restTemplate = restTemplate;
		this.customHeaders = customHeaders;
		this.getEntity = getEntity;
		this.postEntity = postEntity;
	}

	  public ResponseEntity<String> DeploySimpleCatalog(String url, NoInputDeployment noInputDeployment) {
	  
			  postEntity.setHeaders(customHeaders);
			 
			  JsonObject body = new JsonObject();
			  JsonObject inputs = new JsonObject();
			  body.addProperty("bulkRequestCount",1);
			  body.addProperty("deploymentName",noInputDeployment.getDeploymentName());
			  body.add("inputs", inputs);
			  System.out.println("priject id is " + noInputDeployment.getProjectId());
			  body.addProperty("projectId", noInputDeployment.getProjectId());
			  body.addProperty("reason",""); 
			  body.addProperty("version", noInputDeployment.getVersion());
			  postEntity.setBody(body);
			  
			  return restTemplate.exchange(url, HttpMethod.POST, postEntity.getEntity(),
			  String.class);
			 
	  }
	  
	  public DeploymentsList getDeployment(String url ) {
			getEntity.setHeaders(customHeaders);
			return restTemplate.exchange(url, HttpMethod.GET ,getEntity.getEntity(),
					DeploymentsList.class).getBody();
		}
		
	  public  ResponseEntity<String> getStatus(String url, String deploymentId){
		  getEntity.setHeaders(customHeaders);
		  return restTemplate.exchange(url, HttpMethod.GET, getEntity.getEntity(),
				  String.class);
	  }
	 
}
