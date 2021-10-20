package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.DeploymentService;
import com.example.models.DeploymendId;
import com.example.models.deployments.Deployment;
import com.example.models.deployments.NoInputDeployment;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class DeploymentsController {

	
	  @Autowired
	  DeploymentService DeploymentService;
	 
	  @PostMapping("deploySimpleCatalog") 
	 public ResponseEntity<String> deploySimpleCatalog(@RequestBody NoInputDeployment
			  noInputDeployment) { 
	  String url = "https://api.staging.symphony-dev.com/catalog/api/items/"+noInputDeployment
			  .getId()+"/request"; 
	   var check =  DeploymentService.DeploySimpleCatalog(url, noInputDeployment); 
	   System.out.println("Body is" + check.getBody());
	
	   return check;
	  }
	  
	  @GetMapping("getDeployments")
		public List<Deployment> getDeployments() {
			String url = "https://api.staging.symphony-dev.com/deployment/api/deployments";
			//returning it with .getContent witch means it will return what's inside the "content":
			//as a List<Deployments => Spring will send what's inside "content": without the wrapper
			//that way it will be easier for mapping in the Front
			return DeploymentService.getDeployment(url).getContent();
		}
	
	  @PostMapping("getStatus")
	  public ResponseEntity<String> getStatus(@RequestBody DeploymendId deploymentId){
		   String url = "https://api.staging.symphony-dev.com/deployment/api/deployments/"+deploymentId.getDeploymentId();
		   System.out.println("deployment Id is: " +  deploymentId.getDeploymentId());
		   return DeploymentService.getStatus(url,deploymentId.getDeploymentId());
	  }
	 
}
