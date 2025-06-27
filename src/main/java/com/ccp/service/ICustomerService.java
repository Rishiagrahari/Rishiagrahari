package com.ccp.service;

import java.util.List;

import com.ccp.entities.Address;
import com.ccp.entities.Customer;


public interface ICustomerService {
	public Customer addCustomer(Customer c);

	public Customer removeCustomer(long id);

	public Customer updateCustomer(long id, Customer c);

	public Customer getCustomer(long id);

	public List<Customer> getAllCustomers();

	public List<Address> getAllAddress(String userId);
}
