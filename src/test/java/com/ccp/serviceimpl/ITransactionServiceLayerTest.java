package com.ccp.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccp.entities.Account;
import com.ccp.entities.Customer;
import com.ccp.entities.Statement;
import com.ccp.entities.Transaction;
import com.ccp.repositories.ITransactionRepository;
@SpringBootTest
public class ITransactionServiceLayerTest {
	@Autowired
	private TransactionService serv;
	
	@MockBean
	private ITransactionRepository rep;
	
	@Test
	void getAllTransactionIdTest() {
		int id =1;
		doReturn(Optional.of(new Transaction(1,"5555 6666 7890",LocalDate.of(2023, 2, 12),"approved",500,"Credit Card","Business purpose"))).when(rep).getById((long) id);
	}
	@Test
	public void updateTransactionTest()
	{
		int id =1;
		doReturn(Optional.of(new Transaction(1,"5555 6666 7890",LocalDate.of(2023, 2, 12),"approved",500,"Credit Card","Business purpose"))).when(rep).getById((long) id);
	}
	void getTransactionDetailsTest() {
		int id =1;
		doReturn(Optional.of(new Transaction(1,"5555 6666 7890",LocalDate.of(2023, 2, 12),"approved",500,"Credit Card","Business purpose"))).when(rep).getById((long) id);
	}
	@Test
	public void removeTransaction() {
		long id = 1;
		Transaction transaction = new Transaction();
		transaction.setTranId(id);;
		
	}
	@Test
	public void updateTransaction()
	{
		long id = 1;
		doReturn(Optional.of(new Transaction(1,"5555 6666 7890",LocalDate.of(2023, 2, 12),"approved",1000,"Credit Card","Business purpose"))).when(rep).getById((long) id);
	}
	

}
