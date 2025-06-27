package com.ccp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.entities.CreditCard;
import com.ccp.exceptions.CreditCardAlreadyExistException;
import com.ccp.exceptions.NoCreditCardException;
import com.ccp.repositories.ICreditCardRepository;
import com.ccp.service.ICreditCardService;

@Service("creditServ")
public class CreditCardService implements ICreditCardService {
	@Autowired
	private ICreditCardRepository creditRepo;

	@Override
	public CreditCard addCreditCard(CreditCard c) {
		CreditCard cc = creditRepo.addCreditCard(c);
		if (cc != null) {
			throw new CreditCardAlreadyExistException("The card with given number already exist");
		} else {
			creditRepo.save(c);
			return c;
		}
	}

	@Override
	public CreditCard removeCreditCard(long id) {
		Optional<CreditCard> creditOp = creditRepo.findById(id);
		if (creditOp.isPresent()) {
			creditRepo.removeCreditCard(id);
			return creditOp.get();
		} else
		{
			throw new NoCreditCardException("No Credit Card with given id");
		}
	}

	@Override
	public CreditCard updateCreditCard(long id, CreditCard c) {
		Optional<CreditCard> creditOp = creditRepo.findById(id);
		if (creditOp.isPresent()) {
			creditRepo.updateCreditCard(id, c);
			return c;
		} else
		{
			throw new NoCreditCardException("Card not found");
		}
	}

	@Override
	public CreditCard getCreditCard(long id) {
		if (creditRepo.getCreditCard(id) == null)
		{
			throw new NoCreditCardException("No Card with given id");
		}
		else
		{
			return creditRepo.getCreditCard(id);
		}
	}

	@Override
	public List<CreditCard> getAllCreditCards() {
		if (creditRepo.getAllCreditCards().isEmpty())
		{
			throw new NoCreditCardException("No Cards");
		}
		else
		{
			return creditRepo.getAllCreditCards();
		}
	}

	@Override
	public CreditCard getCreditCardByNumber(String number) {
		if (creditRepo.getCreditCardByNumber(number) == null)
		{
			throw new NoCreditCardException("No Card with given id");
		}
		else
		{
			return creditRepo.getCreditCardByNumber(number);
		}
	}

}