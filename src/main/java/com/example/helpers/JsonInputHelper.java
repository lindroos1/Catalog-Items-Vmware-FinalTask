package com.example.helpers;

import java.util.Objects;

import com.example.models.CatalogItems;
import com.example.models.Input;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonInputHelper {

	private Input input;
	private JsonObject jsonObject;
	private  CatalogItems catalogItems;
	
	public JsonInputHelper(Input input,  CatalogItems ccatalogItems) {
		this.input = input;
		jsonObject = new JsonObject();
		this.catalogItems = ccatalogItems;
		createJsonInput();
	}
	
	private void createJsonInput() { 
		number();
		arrayInput();
		
		String();
		passwordInput();
		objectInput();
		
		
		//setID();
		//jsonObject.addProperty("reason","");
		//jsonObject.addProperty("version","");
	}
	
	private void number() {
		if(input.getNumber()!=null) {
			jsonObject.addProperty("numberInput", input.getNumber());
		}
	}
	
	private void setID() {
			jsonObject.addProperty("projectId", this.catalogItems.getProjectIds()[0]);
	}
	
	private void objectInput() {
		/*
		if(!Objects.isNull(input.getObject())) {
			JsonObject element = new JsonObject();
			element.
			element.add();
			jsonObject.add("objectInput", element);
		}
		*/
		JsonObject k = new JsonObject();
		jsonObject.add("objectInput", k);
	}
	
	private void passwordInput() {
		if(input.getPassword()!= null) {
			jsonObject.addProperty("passwordInput", input.getPassword());
		}
	}
	private void String() {
		if(input.getString()!= null) {
			jsonObject.addProperty("stringInput", input.getString());
		}
		
	}
	private void deploymentName() {
		jsonObject.addProperty("deploymentName",input.getDeploymentName());
	}
	private void bulkRequestCount() {
		jsonObject.addProperty("bulkRequestCount",1);
	}
	private void arrayInput() {
		if (input.getArray() != null) {

			JsonArray element = new JsonArray();
			var charArr = input.getArray().toCharArray();
			for(int i = 0; i < charArr.length; i++) {
				element.add(charArr[i]);
			}
			jsonObject.add("arrayInput", element);
		}
	}
	
	public JsonObject getJsonInput() {
		return jsonObject;
	}
}
