package com.ccp.exceptions;

public class UserIdNotFound extends RuntimeException{
	public UserIdNotFound(String msg) {
		super(msg);
	}

}
