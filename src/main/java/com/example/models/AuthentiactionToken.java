package com.example.models;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class AuthentiactionToken implements Serializable  {

	
	private static final long serialVersionUID = 1L;
	private String access_token;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
