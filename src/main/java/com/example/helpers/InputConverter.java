package com.example.helpers;

public class InputConverter {

	static String[] possibleInputs ={"array", "integer", "number", "object", "string", "boolean", "password"};
	public static  String[] convertFromUnright(String[] input) {
		if(input.length>0) {
			 for(int i = 0; i < input.length; i++) {
				 for(int b = 0; b < possibleInputs.length; b++) {
					 if(input[i].toLowerCase().contains(possibleInputs[b])) {
						 var newValue = possibleInputs[b];
						 input[i] = newValue;
					 }
				 }
				
			 }
		 }
		return input;
	}
	
	public static String[] setSchema(String[] input, String[] schema) {	 
		  int len = schema.length;
		  input = new String[len];
		  for(int c = 0; c < schema.length; c++) {
				input[c] = schema[c];
			 }
		return input;
	}
}
