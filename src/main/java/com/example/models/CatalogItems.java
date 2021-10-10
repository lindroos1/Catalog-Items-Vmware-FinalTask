package com.example.models;

import java.util.List;

public class CatalogItems {

	String id;
	String name;
	String description;
	//String createdAt;
	//String createdBy;
	//String lastUpdatedAt;
	//String lastUpdatedBy;
	Schema Schema;
	String[] projectIds;
	Input input;

	
	public Input getInput() {
		return input;
	}
	public void setInput(Input input) {
		this.input = input;
	}
	public String[] getProjectIds() {
		return projectIds;
	}
	public void setProjectIds(String[] projectIds) {
		this.projectIds = projectIds;
	}
	public Schema getSchema() {
		return Schema;
	}
	public void setSchema(Schema schema) {
		Schema = schema;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
