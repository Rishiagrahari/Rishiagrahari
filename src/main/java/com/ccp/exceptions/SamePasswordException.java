package com.ccp.exceptions;

public class SamePasswordException extends RuntimeException{
	public SamePasswordException(String msg) {
		super(msg);
	}

}
