package com.ccp.exceptions;

public class InsufficientBalanceException extends RuntimeException {
	public InsufficientBalanceException(String msg){
		super(msg);
	}

}
