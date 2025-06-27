package com.ccp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.entities.Account;
import com.ccp.exceptions.AccountAlreadyExist;
import com.ccp.exceptions.NoAccountException;
import com.ccp.repositories.IAccountRepository;
import com.ccp.service.IAccountService;

@Service("accountServ")
public class AccountService implements IAccountService {
	@Autowired
	private IAccountRepository accountRepo;
	

	public Account addAccount(Account a) {
	     Account aAdd = accountRepo.addAccount(a);
	     if(aAdd!=null)
	    	 throw new AccountAlreadyExist("This account already exists");
	     else
	     {
	    	 accountRepo.save(a);
	    	 return a;
	     }
	}

	public Account updateAccount(long id, Account a) {
		Optional<Account> accountOp = accountRepo.findById(id);
		if (accountOp.isPresent()) {
			accountRepo.updateAccount(id, a);
			return a;
		} else
			throw new NoAccountException("Account not found");
	}

	public Account getAccount(long id) {
		if (accountRepo.getAccount(id) == null)
			throw new NoAccountException("No Account with given id");
		else
			return accountRepo.getAccount(id);

	}

	@Override
	public Account removeAccount(long id) {
		Optional<Account> accOp = accountRepo.findById(id);
		if (accOp.isPresent()) {
			accountRepo.removeAccount(id);
			return accOp.get();
		} else
			throw new NoAccountException("No Account with given id");
	}

	@Override
	public List<Account> getAllAccounts() {
		if (accountRepo.getAllAccounts().isEmpty()) {
			throw new NoAccountException("No Accounts");
		} else
			return accountRepo.getAllAccounts();

	}
}