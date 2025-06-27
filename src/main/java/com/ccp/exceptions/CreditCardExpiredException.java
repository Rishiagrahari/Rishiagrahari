package com.ccp.exceptions;

public class CreditCardExpiredException extends RuntimeException {
	public CreditCardExpiredException(String msg){
		super(msg);
	}

}
