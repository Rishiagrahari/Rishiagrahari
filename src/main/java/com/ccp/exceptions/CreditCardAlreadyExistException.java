package com.ccp.exceptions;

public class CreditCardAlreadyExistException extends RuntimeException {
	public CreditCardAlreadyExistException(String msg){
		super(msg);
	}

}
