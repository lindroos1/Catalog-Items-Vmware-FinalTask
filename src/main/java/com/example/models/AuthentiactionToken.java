package com.example.models;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class AuthentiactionToken implements Serializable  {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
