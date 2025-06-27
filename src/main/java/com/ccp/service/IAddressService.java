package com.ccp.service;

import java.util.List;

import com.ccp.entities.Address;

public interface IAddressService {
	Address addAddress(Address a);

	Address removeAddress(long id);

	Address updateAddress(long id, Address a);

	Address getAddress(long id);

	List<Address> getAllAddress();
}
