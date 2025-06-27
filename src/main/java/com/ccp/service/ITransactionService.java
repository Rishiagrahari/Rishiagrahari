package com.ccp.service;

import java.util.List;

import com.ccp.entities.CreditCard;
import com.ccp.entities.Transaction;

public interface ITransactionService {

	public Transaction addTransaction(Transaction t);

	public Transaction removeTransaction(long id);

	public Transaction updateTransaction(long id, Transaction t);

	public Transaction getTransactionDetails(long id);

	public List<Transaction> getAllTransactions();

	// now for customer mapping
	List<Transaction> getTransactionForCard(String cardNumber);

	List<Transaction> getAllTransactionsByCustomer(long id, CreditCard c);

}
