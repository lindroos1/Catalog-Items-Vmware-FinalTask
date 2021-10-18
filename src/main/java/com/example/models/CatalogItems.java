package com.example.models;

import java.util.List;

public class CatalogItems {

	String id;
	String name;
	String description;
	Type type;
	String iconId;
	Projects[] projects;

	
	public Projects[] getProjects() {
		return projects;
	}
	public void setProjects(Projects[] projects) {
		this.projects = projects;
	}
	public String getIconId() {
		return iconId;
	}
	public void setIconId(String iconId) {
		this.iconId = iconId;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
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
