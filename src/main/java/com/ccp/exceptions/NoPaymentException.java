package com.ccp.exceptions;

public class NoPaymentException extends RuntimeException {
	public NoPaymentException(String msg)
	{
		super(msg);
	}

}
