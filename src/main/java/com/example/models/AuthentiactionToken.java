package com.example.models;

import java.io.Serializable;

public class AuthentiactionToken implements Serializable  {

	private long access_token;

	public long getAccess_token() {
		return access_token;
	}

	public void setAccess_token(long access_token) {
		this.access_token = access_token;
	}
	
}
