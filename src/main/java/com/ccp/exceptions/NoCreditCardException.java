package com.ccp.exceptions;

public class NoCreditCardException extends RuntimeException {
	public NoCreditCardException(String msg) {
		super(msg);
	}

}
