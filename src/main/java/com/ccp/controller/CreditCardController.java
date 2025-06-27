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

import com.ccp.entities.CreditCard;
import com.ccp.service.ICreditCardService;

@RestController
public class CreditCardController {
	@Autowired
	private ICreditCardService creditServ;
	@PostMapping("/creditcards")
	public ResponseEntity<CreditCard> addCreditCard(@Valid @RequestBody CreditCard c) {
	 return new ResponseEntity<>(creditServ.addCreditCard(c), HttpStatus.CREATED);
	    	  
	}
	
	@DeleteMapping("/creditcards/{id}")
	public ResponseEntity<CreditCard> removeCreditCard(@PathVariable("id")long id)
	{
		
		 return new ResponseEntity<>(creditServ.removeCreditCard(id), HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/creditcards/{id}")
	public ResponseEntity<CreditCard> getCreditCardById(@PathVariable("id")long id)
	{
		return new ResponseEntity<>(creditServ.getCreditCard(id), HttpStatus.FOUND);
	}
	@GetMapping("/creditcards")
	public ResponseEntity<List<CreditCard>>getCreditCards(){
		return new ResponseEntity<>(creditServ.getAllCreditCards(), HttpStatus.FOUND);
	}
	@PutMapping("/creditcards/{id}")
	public ResponseEntity<CreditCard>updateCreditCardById(@PathVariable long id,@RequestBody CreditCard c){
		return new ResponseEntity<>(creditServ.updateCreditCard(id, c), HttpStatus.ACCEPTED);
	}

}
