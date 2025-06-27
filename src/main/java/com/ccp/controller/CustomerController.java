package com.ccp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccp.entities.Customer;
import com.ccp.service.ICustomerService;

@RestController
public class CustomerController {
	@Autowired
	private ICustomerService serv;
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer c) {
	 return new ResponseEntity<>(serv.addCustomer(c), HttpStatus.CREATED);
	    	  
	}
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id")long id)
	{
		
		 return new ResponseEntity<>(serv.removeCustomer(id), HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id")long id)
	{
		return new ResponseEntity<>(serv.getCustomer(id), HttpStatus.FOUND);
	}
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>>getCustomers(){
		return new ResponseEntity<>(serv.getAllCustomers(), HttpStatus.FOUND);
	}
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer>updateCustomerById(@PathVariable long id,@RequestBody Customer c){
		return new ResponseEntity<>(serv.updateCustomer(id, c), HttpStatus.ACCEPTED);
	}

}
