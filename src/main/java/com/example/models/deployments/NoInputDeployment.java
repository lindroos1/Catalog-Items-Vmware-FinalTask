package com.example.models.deployments;

public class NoInputDeployment {
	String id;
	String projectId;
	String deploymentName;
	String version;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getDeploymentName() {
		return deploymentName;
	}
	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
