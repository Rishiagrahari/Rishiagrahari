package com.ccp.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccp.entities.Address;
import com.ccp.entities.CreditCard;
import com.ccp.entities.Customer;
import com.ccp.entities.Transaction;
import com.ccp.repositories.ICreditCardRepository;

@SpringBootTest
public class ICreditCardServiceLayerTest {
	
	@Autowired
	private CreditCardService serv;
	@MockBean
	private ICreditCardRepository rep;
	@Test
	void getAllCreditCards_success() {
		when(rep.getAllCreditCards()).thenReturn(Stream.of(new CreditCard(1,"Sachin","Visa","5555 6666 7890",LocalDate.of(20023, 6, 27),"HDFC"))
				.collect(Collectors.toList()));
		assertEquals(1,serv.getAllCreditCards().size());
	}
	@Test
	void addCreditCardTest() {
		CreditCard creditcard = new CreditCard(1,"Sachin","Visa","5555 6666 7890",LocalDate.of(20023, 6, 27),"HDFC");
		when(rep.save(creditcard)).thenReturn(creditcard);
		assertEquals(creditcard,serv.addCreditCard(creditcard));
	}
	@Test
	void getAllCreditCardIdTest() {
		int id =1;
		doReturn(Optional.of(new CreditCard(1,"Sachin","Visa","5555 6666 7890",LocalDate.of(20023, 6, 27),"HDFC"))).when(rep).getById((long) id);
	}
	@Test
	public void removeCreditCardIdTest() {
		long id = 1;
		CreditCard CreditCard = new CreditCard();
		CreditCard.setId(id);
		
	}
	
	
	
}
	

