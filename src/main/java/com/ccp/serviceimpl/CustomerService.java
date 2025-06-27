package com.ccp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ccp.entities.Address;
import com.ccp.entities.Customer;
import com.ccp.entities.Statement;
import com.ccp.exceptions.NoUserPresent;
import com.ccp.exceptions.UserAlreadyExistException;
import com.ccp.exceptions.UserIdNotFound;
import com.ccp.repositories.ICustomerRepository;
import com.ccp.service.ICustomerService;
import com.ccp.service.IStatementService;

@Service("customerServ")
public class CustomerService implements ICustomerService{

	@Autowired
	private ICustomerRepository rep;
	@Autowired
	private IStatementService statServ;
	public Customer addCustomer(Customer c) {
		//here check that same records not inserted twice , means record with same userId and password and userId should
				//be unique so maintain that relation also, include this check in customer service layer
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(c.getPassword());
		c.setPassword(encryptedPassword);
	      Customer cc = rep.addCustomer(c);
	      if(cc!=null) {
	    	 throw new UserAlreadyExistException("User already exists sign in instead");
	      }
	      else {
	    	  rep.save(c);
	    	  return c;
	    	//here throw user already exist sign in instead exception
	      }
	}
	public Customer removeCustomer(long id) {
		Customer c= rep.removeCustomer(id);
		if (c!=null) {
			rep.deleteById(id);
			return c;
		} else
		{
			throw new UserIdNotFound("No user present");
		}
	}
	public  Customer updateCustomer(long id,Customer c) {
		
				
	   Optional<Customer> customerOp = rep.findById(id);
	   if(customerOp.isPresent())
	   {
		   rep.updateCustomer(id, c);
			return c;
	   }
	   else
	   {
		   throw new UserIdNotFound("User not found");
	   }
	}
	public Customer getCustomer(long id) {
		if(rep.existsById(id)) {
		return rep.getCustomer(id);
		}
		else
		{
			throw new UserIdNotFound("No user found");
		}
	}
	public  List<Customer> getAllCustomers() {
		if(rep.getAllCustomers().isEmpty())
			throw new NoUserPresent("No user present");
		else
		{
		return rep.getAllCustomers();
		}
	}

	@Override
	public List<Address> getAllAddress(String userId) {
		return rep.getAllAddress(userId);
		
	}
	public List<Statement> getMyStatements(Customer c){
		return statServ.getCustomerStatement(c);
	}
	
}