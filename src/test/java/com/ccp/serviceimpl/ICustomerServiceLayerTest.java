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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.ccp.entities.Customer;
import com.ccp.entities.Transaction;
import com.ccp.repositories.ICustomerRepository;

@SpringBootTest
public class ICustomerServiceLayerTest {
	@Autowired
	private CustomerService serv;
	@MockBean
	private ICustomerRepository rep;

	@Test
	void getAllCustomers_success() {
		when(rep.getAllCustomers()).thenReturn(Stream.of(new Customer("Rishi Agrahari","rishi@gmail.com", "6268718665", LocalDate.of(2000, 1, 30), null, null, null, null, null))
				.collect(Collectors.toList()));
		assertEquals(1,serv.getAllCustomers().size());
		
	}

	@Test
	void getAllCustomerIdTest() {
		int custid = 1;
		doReturn(Optional.of(new Customer("Rishi Agrahari", "rishi@gmail.com", "6268718665", LocalDate.of(2000, 1, 30),
				null, null, null, null, null))).when(rep).getById((long) custid);
	}

	@Test
	public void removeCustomer() {
		long id = 1;
		Customer customer = new Customer();
		customer.setId(id);
		
	}

	@Test
	public void updateCustomerTest() {

		int custid = 1;
		doReturn(Optional.of(new Customer("Rishi Agrahari", "rishi@gmail.com", "6268718665", LocalDate.of(2000, 1, 30),
				null, null, null, null, null))).when(rep).getById((long) custid);
	}
}
