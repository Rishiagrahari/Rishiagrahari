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

import com.ccp.entities.Statement;
import com.ccp.service.IStatementService;


@RestController
public class StatementController {
	@Autowired
	private IStatementService statementServ;
	
	@PostMapping("/statements")
	public ResponseEntity<Statement> addStatement(@Valid @RequestBody Statement s) {
	 return new ResponseEntity<>(statementServ.addStatement(s), HttpStatus.CREATED);
	    	  
	}
	@DeleteMapping("/statements/{id}")
	public ResponseEntity<Statement> removeStatement(@PathVariable("id")long id)
	{
		
		 return new ResponseEntity<>(statementServ.removeStatement(id), HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/statements/{id}")
	public ResponseEntity<Statement> getStatementById(@PathVariable("id")long id)
	{
		return new ResponseEntity<>(statementServ.getStatement(id), HttpStatus.FOUND);
	}
	@GetMapping("/statements")
	public ResponseEntity<List<Statement>>getStatements(){
		return new ResponseEntity<>(statementServ.getAllStatements(), HttpStatus.FOUND);
	}
	@PutMapping("/statements/{id}")
	public ResponseEntity<Statement>updateStatementById(@PathVariable long id,@RequestBody Statement s){
		return new ResponseEntity<>(statementServ.updateStatement(id, s), HttpStatus.ACCEPTED);
	}
	@GetMapping("/statements/billed")
	public ResponseEntity<List<Statement>>getBilledStatements(){
		return new ResponseEntity<>(statementServ.getBilledStatement(), HttpStatus.FOUND);
	}
	@GetMapping("/statements/unbilled")
	public ResponseEntity<List<Statement>>getUnBilledStatements(){
		return new ResponseEntity<>(statementServ.getUnbilledStatement(), HttpStatus.FOUND);
	}
	

}
