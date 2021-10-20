package com.example.models.catalogItems;


/*
 * Wrapper class so we can get name of the template associated with that catalog item 
 * "name":"VMware Cloud Templates" - for example
 */
public class Type {

	String id;
	String link;
	String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
