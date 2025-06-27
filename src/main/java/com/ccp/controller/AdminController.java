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

import com.ccp.entities.Admin;
import com.ccp.service.IAdminService;

@RestController
public class AdminController {

	@Autowired
	private IAdminService adminServ;
	
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAdmins(){
		
		return new ResponseEntity<>(adminServ.getAllAdmins(), HttpStatus.FOUND);
	}
	
	 @PostMapping("/admins")
		public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin a) {
		 return new ResponseEntity<>(adminServ.addAdmin(a), HttpStatus.CREATED);
		    	  
		}
		@DeleteMapping("/admins/{id}")
		public ResponseEntity<Admin> removeAdmin(@PathVariable("id")long id)
		{
			
			 return new ResponseEntity<>(adminServ.removeAdmin(id), HttpStatus.ACCEPTED);
			
		}
		@GetMapping("/admins/{id}")
		public ResponseEntity<Admin> getAdminById(@PathVariable("id")long id)
		{
			return new ResponseEntity<>(adminServ.getAdmin(id), HttpStatus.FOUND);
		}
		@PutMapping("/admins/{id}")
		public ResponseEntity<Admin>updateAdminById(@PathVariable long id,@RequestBody Admin a){
			return new ResponseEntity<>(adminServ.updateAdmin(id, a), HttpStatus.ACCEPTED);
		}

		  
	}
	

