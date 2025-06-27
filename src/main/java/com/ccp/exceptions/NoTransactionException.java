package com.ccp.exceptions;

public class NoTransactionException extends RuntimeException {
	public NoTransactionException(String msg) {
		super(msg);
	}

}
