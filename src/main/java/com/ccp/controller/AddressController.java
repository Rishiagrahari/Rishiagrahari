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

import com.ccp.entities.Address;
import com.ccp.service.IAddressService;

/**
 * This is the Rest controller for Address entity
 * @author risagrah
 * @since 10-02-2023
 *
 */
@RestController
public class AddressController {
	@Autowired
	private IAddressService addServ;
	
	@PostMapping("/address")
	public ResponseEntity<Address> addAddress(@Valid @RequestBody Address a) {
	 return new ResponseEntity<>(addServ.addAddress(a), HttpStatus.CREATED);
	    	  
	}
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Address> removeAddress(@PathVariable("id")long id)
	{
		
		 return new ResponseEntity<>(addServ.removeAddress(id), HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable("id")long id)
	{
		return new ResponseEntity<>(addServ.getAddress(id), HttpStatus.FOUND);
	}
	@GetMapping("/address")
	public ResponseEntity<List<Address>>getAddress(){
		return new ResponseEntity<>(addServ.getAllAddress(), HttpStatus.FOUND);
	}
	@PutMapping("/address/{id}")
	public ResponseEntity<Address>updateAddressById(@PathVariable long id,@RequestBody Address a){
		return new ResponseEntity<>(addServ.updateAddress(id, a), HttpStatus.ACCEPTED);
	}
	
	

}
