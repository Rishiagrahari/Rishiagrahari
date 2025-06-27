package com.ccp.service;

import java.util.List;

import com.ccp.entities.CreditCard;


public interface ICreditCardService {

	public CreditCard addCreditCard(CreditCard c);

	public CreditCard removeCreditCard(long id);

	public CreditCard updateCreditCard(long id, CreditCard c);

	public CreditCard getCreditCard(long id);

	public List<CreditCard> getAllCreditCards();

	// customer mapping
	public CreditCard getCreditCardByNumber(String number);

}
