package com.ccp.exceptions;

public class AlreadyExistStatement extends RuntimeException {
	public AlreadyExistStatement(String msg){
		super(msg);
	}

}
