package com.ccp.exceptions;

public class AddressAlreadyExistException extends RuntimeException {
	public AddressAlreadyExistException(String msg){
		super(msg);
	}

}
