package com.ccp.service;

import java.util.List;

import com.ccp.entities.Account;

public interface IAccountService {
	Account addAccount(Account a);

	Account removeAccount(long id);

	Account updateAccount(long id, Account a);

	Account getAccount(long id);

	List<Account> getAllAccounts();
}
