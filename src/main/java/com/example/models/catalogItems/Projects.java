package com.example.models.catalogItems;

/*
 * wrapper class to get projects associated with that catalog item
 * "Another Bootcamp Project - for example
 * NOTE! - this class wraps different id and name than Type class!
 */
public class Projects {

	String name;
	String  id;

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
}
