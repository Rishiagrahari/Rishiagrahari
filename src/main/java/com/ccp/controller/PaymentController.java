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

import com.ccp.entities.Payment;
import com.ccp.service.IPaymentService;


@RestController
public class PaymentController {
	@Autowired
	private IPaymentService payServ;
	
	@PostMapping("/payments")
	public ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment c) {
	 return new ResponseEntity<>(payServ.addPayment(c), HttpStatus.CREATED);
	    	  
	}
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Payment> removePayment(@PathVariable("id")long id)
	{
		
		 return new ResponseEntity<>(payServ.removePayment(id), HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/payments/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id")long id)
	{
		return new ResponseEntity<>(payServ.getPayment(id), HttpStatus.FOUND);
	}
	@GetMapping("/payments")
	public ResponseEntity<List<Payment>>getPayments(){
		return new ResponseEntity<>(payServ.getAllPayments(), HttpStatus.FOUND);
	}
	@PutMapping("/payments/{id}")
	public ResponseEntity<Payment>updatePaymentById(@PathVariable long id,@RequestBody Payment c){
		return new ResponseEntity<>(payServ.updatePayment(id, c), HttpStatus.ACCEPTED);
	}

}
