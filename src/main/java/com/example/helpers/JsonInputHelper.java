package com.example.helpers;

import java.util.HashMap;
import java.util.Objects;

import com.example.models.CatalogItems;
import com.example.models.Input;
import com.example.models.Schema;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonInputHelper {

	private Input input;
	private JsonObject jsonObject;
	private  CatalogItems catalogItems;
	private Schema localSchema;
	private HashMap<String, String> container;
	
	public JsonInputHelper(Input input,  CatalogItems ccatalogItems, Schema schema) {
		this.input = input;
		this.localSchema = schema;
		container = new HashMap<String, String>();
		getValues();
		jsonObject = new JsonObject();
		this.catalogItems = ccatalogItems;
		createJsonInput();
	}
	
	private void getValues() {
		 String[] possibleInputs ={"rray", "nteger", "umber", "bject", "tring", "oolean", "assword"};
		for(int i = 0; i < localSchema.getRequired().length; i++) {
			for(int b = 0; b < possibleInputs.length; b++) {
				if(localSchema.getRequired()[i].contains(possibleInputs[b])) {
					container.put(possibleInputs[b], localSchema.getRequired()[i]);
					System.out.println(localSchema.getRequired()[i]);
				}
			}
		}
	}
	
	private void createJsonInput() { 
		number();
		arrayInput();
		
		String();
		passwordInput();
		objectInput();
		integer();
		

	}
	//why the hell Catalog Item with all types of inputs accepts number or string 
	private void number() {
		if(input.getNumber()!=null) {
			jsonObject.addProperty(container.get("umber"), input.getNumber().toString());
		}
	}
	
	private void integer() {
		if(input.getInteger()!=null) {
			jsonObject.addProperty(container.get("nteger"), input.getInteger());
		}
	}
	
	
	private void objectInput() {
		JsonObject k = new JsonObject();
		jsonObject.add("objectInput", k);
	}
	
	private void passwordInput() {
		if(input.getPassword()!= null) {
			jsonObject.addProperty(container.get("assword"), input.getPassword());
		}
	}
	private void String() {
		if(input.getString()!= null) {
			jsonObject.addProperty(container.get("tring"), input.getString());
		}
		
	}
	private void arrayInput() {
		if (input.getArray() != null) {

			JsonArray element = new JsonArray();
			var charArr = input.getArray().toCharArray();
			for(int i = 0; i < charArr.length; i++) {
				element.add(charArr[i]);
			}
			jsonObject.add(container.get("rray"), element);
		}
	}
	
	public JsonObject getJsonInput() {
		return jsonObject;
	}
}
