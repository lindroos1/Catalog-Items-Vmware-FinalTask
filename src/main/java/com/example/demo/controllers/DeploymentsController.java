package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.DeploymentService;

@RestController
public class DeploymentsController {

	/*
	 * @Autowired DeploymentService DeploymentService;
	 * 
	 * @PostMapping("deploySimpleCatalog") public String
	 * deploySimpleCatalog(@RequestBody ) { String url =
	 * "https://api.staging.symphony-dev.com/catalog/api/items/id/request"; return
	 * DeploymentService.DeploySimpleCatalog(url); }
	 */
}
