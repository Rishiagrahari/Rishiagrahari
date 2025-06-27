package com.ccp.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccp.entities.Account;
import com.ccp.entities.Address;
import com.ccp.entities.CreditCard;
import com.ccp.entities.Customer;
import com.ccp.entities.Statement;
import com.ccp.repositories.IAccountRepository;
import com.ccp.repositories.IAddressRepository;

@SpringBootTest
public class IAccountServiceLayerTest {
	@Autowired
	private AccountService serv;
	@MockBean
	private IAccountRepository rep;
	
	@Test
	void addAccountTest() {
		Account account = new Account(1,"Saving",4000,"Personal");
		when(rep.save(account)).thenReturn(account);
		assertEquals(account,serv.addAccount(account));
	}
	
	@Test
	void getAllAccountsTest() {
		when(rep.getAllAccounts()).thenReturn(Stream.of(new Account(1,"Saving",4000,"Personal"))
				.collect(Collectors.toList()));
		assertEquals(1,serv.getAllAccounts().size());
		
	}
	@Test
	void getAllAccountIdTest() {
		int id =1;
		doReturn(Optional.of(new Account(1,"Saving",4000,"Personal"))).when(rep).getById((long) id);
	}
	@Test
	public void testRemoveAccount_Success() {
		long id = 1;
		Account account = new Account();
		account.setAccountId(1);
		account.setAccountName("Saving");
		account.setBalance(1000.0);
	}
}
