package com.ccp.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccp.entities.Account;
import com.ccp.entities.Customer;
import com.ccp.entities.Payment;
import com.ccp.entities.Transaction;
import com.ccp.repositories.IPaymentRepository;

@SpringBootTest
public class IPaymentServiceLayerTest {

	@Autowired
	private PaymentService serv;
	@MockBean
	private IPaymentRepository rep;

	@Test
	void getPaymentIdTest() {
		int id = 1;
		doReturn(Optional.of(new Payment(1, "creditcard", 500))).when(rep).getById((long) id);
	}

	@Test
	public void removePayment() {
		long id = 1;
		Payment payment = new Payment();
		payment.setPaymentId(id);

	}
	@Test
	public void updatePaymentTest() {
		int id = 1;
		doReturn(Optional.of(new Payment(1, "creditcard", 500))).when(rep).getById((long) id);
	}

}
