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

import com.ccp.entities.Transaction;
import com.ccp.service.ITransactionService;

@RestController
public class TransactionController {
	@Autowired
	private ITransactionService tranServ;
	
	@PostMapping("/transactions")
	public ResponseEntity<Transaction> addTransaction(@Valid @RequestBody Transaction t) {
	 return new ResponseEntity<>(tranServ.addTransaction(t), HttpStatus.CREATED);
	    	  
	}
	@DeleteMapping("/transactions/{id}")
	public ResponseEntity<Transaction> removeTransaction(@PathVariable("id")long id)
	{
		
		 return new ResponseEntity<>(tranServ.removeTransaction(id), HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/transactions/{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable("id")long id)
	{
		return new ResponseEntity<>(tranServ.getTransactionDetails(id), HttpStatus.FOUND);
	}
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>>getTransactions(){
		return new ResponseEntity<>(tranServ.getAllTransactions(), HttpStatus.FOUND);
	}
	@PutMapping("/transactions/{id}")
	public ResponseEntity<Transaction>updateTransactionById(@PathVariable long id,@RequestBody Transaction t){
		return new ResponseEntity<>(tranServ.updateTransaction(id, t), HttpStatus.ACCEPTED);
	}


}
