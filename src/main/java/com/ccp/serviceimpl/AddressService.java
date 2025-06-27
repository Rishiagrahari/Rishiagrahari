package com.ccp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.entities.Address;
import com.ccp.exceptions.AddressAlreadyExistException;
import com.ccp.exceptions.NoAddressException;
import com.ccp.repositories.IAddressRepository;
import com.ccp.service.IAddressService;

@Service("addServ")
public class AddressService implements IAddressService {
	@Autowired
	private IAddressRepository addRepo;

	@Override
	public Address addAddress(Address a) {
		 Address address= addRepo.addAddress(a);
	      if(address!=null) {
	    	 throw new AddressAlreadyExistException("User already exists sign in instead");
	      }
	      else {
	    	  addRepo.save(a);
	    	  return a;
	      }
	}

	@Override
	public Address removeAddress(long id) {
		Optional<Address> addressOp = addRepo.findById(id);
		if (addressOp.isPresent()) {
			addRepo.removeAddress(id);
			return addressOp.get();
		} else {
			throw new NoAddressException("No Address with given id");
		}
	}

	@Override
	public Address updateAddress(long id, Address a) {
		Optional<Address> addressOp = addRepo.findById(id);
		if (addressOp.isPresent()) {
			addRepo.updateAddress(id, a);
			return a;
		} else {
			throw new NoAddressException("Address not found");
		}
	}

	@Override
	public Address getAddress(long id) {
		Optional<Address> addressOp = addRepo.findById(id);
		if (addressOp.isPresent()) {
			return addRepo.getAddress(id);
		} else {
			throw new NoAddressException("Address not found");
		}
	}

	@Override
	public List<Address> getAllAddress() {
		if (addRepo.getAllAddress().isEmpty())
		{
			throw new NoAddressException("Address not found");
		}
		else
		{
			return addRepo.getAllAddress();
		}
	}

}