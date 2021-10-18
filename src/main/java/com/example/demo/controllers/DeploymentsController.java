package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.DeploymentService;
import com.example.models.NoInputDeployment;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class DeploymentsController {

	
	  @Autowired
	  DeploymentService DeploymentService;
	 
	  @PostMapping("deploySimpleCatalog") 
	 public String deploySimpleCatalog(@RequestBody NoInputDeployment
			  noInputDeployment) { 
	  String url = "https://api.staging.symphony-dev.com/catalog/api/items/"+noInputDeployment
			  .getId()+"/request"; 
	  return DeploymentService.DeploySimpleCatalog(url, noInputDeployment); 
	  }
	 
}
