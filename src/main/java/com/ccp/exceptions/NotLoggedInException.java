package com.ccp.exceptions;

public class NotLoggedInException extends RuntimeException{
	public NotLoggedInException(String msg) {
		super(msg);
	}

}
