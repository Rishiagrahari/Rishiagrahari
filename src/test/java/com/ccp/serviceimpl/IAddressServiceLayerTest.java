package com.ccp.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccp.entities.Address;
import com.ccp.repositories.IAddressRepository;

@SpringBootTest
public class IAddressServiceLayerTest {
	@Autowired
	private AddressService serv;
	@MockBean
	private IAddressRepository rep;
	
	@Test
	void addAddressTest() {
		Address address = new Address(1,"404","MG Road","Mg","Manchinahalli","Karnataka",561211);
		when(rep.save(address)).thenReturn(address);
		assertEquals(address,serv.addAddress(address));
	}
	@Test
	void getAllAddressTest() {
		when(rep.getAllAddress()).thenReturn(Stream.of(new Address(1,"404","MG Road","Mg","Manchinahalli","Karnataka",561211))
				.collect(Collectors.toList()));
		assertEquals(1,serv.getAllAddress().size());
	}
	@Test
	void getAddressIdTest() {
		int id =1;
		doReturn(Optional.of(new Address(1,"404","MG Road","Mg","Manchinahalli","Karnataka",561211))).when(rep).getById((long) id);
	}
	@Test
	public void removeAddress() {
		long id = 1;
		Address address = new Address();
		address.setId(1);
		
	}
	
	
}
