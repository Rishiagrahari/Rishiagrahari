package com.ccp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccp.entities.User;
import com.ccp.exceptions.NotLoggedInException;
import com.ccp.exceptions.SamePasswordException;
import com.ccp.exceptions.UserIdNotFound;
import com.ccp.exceptions.WrongPasswordException;
import com.ccp.service.IUserService;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUserService userServ;
	private User currentUser;

	@PostMapping("/signIn")
	public ResponseEntity<User> signInUser(@RequestBody User u) {
		Optional<User> userOp = userServ.findByUserId(u.getUserId());
		if (userOp.isPresent()) {
			// if user doesn't exist then
			// throw no user with given user id found
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			User dbUser = userOp.get();
			if (bcrypt.matches(u.getPassword(), dbUser.getPassword())) {
				currentUser = userServ.signIn(u);
				currentUser.setStatus(true);

				return new ResponseEntity<>(currentUser, HttpStatus.ACCEPTED);
			} else {
				throw new WrongPasswordException("wrong password");
			}

		} else {
			throw new UserIdNotFound("No user exists");
		}
	}

	@PostMapping("/signOut")
	public ResponseEntity<String> signOutUser(@RequestBody User u) {
		// check if user of this type exist if yes then return null and also check
		// status if its true then only signout
		// if status is true check @RequestBody's user that it should only sign out the
		// current user that is signed in
		// signout method should only check whether the user id and password match or
		// not according to this it should
		// signout users that are only authorised , and in service we will call only
		// this
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

		if (currentUser.isStatus() && currentUser.getUserId().equals(u.getUserId())
				&& bcrypt.matches(u.getPassword(), currentUser.getPassword())) {
			currentUser.setStatus(false);
			return new ResponseEntity<>("sign out  : " + u.getUserId(), HttpStatus.ACCEPTED);
		
		} else {
			// throw an exception that you are not logged in
			// if logged in but user is wrong throw invalid user exception
			throw new NotLoggedInException("Not logged in to any account");
		}
	}

	// it should give the userId first and then give previous password in order to
	// change password
	// also check status is it is true then only change password
	@PutMapping("/changePassword/{id}")
	public ResponseEntity<String> changePasswordForUser(@PathVariable("id") long id, @RequestBody User u) {
		User repUser = userServ.changePassword(id, u);
		// check for status also
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		if (repUser != null) {
			if (!bcrypt.matches(u.getPassword(), repUser.getPassword())) {
				repUser.setPassword(bcrypt.encode(u.getPassword()));
				User cc =repUser;
				//after changing the repUser password we need to save it to persist it otherwise this change 
				//will not reflect on database
				userServ.save(cc);
				currentUser =  repUser;
				return new ResponseEntity<>("changed", HttpStatus.ACCEPTED);
			} 
			else {
				//throw same password entered exception
				throw new SamePasswordException("Same password entered");
			}
		} else {
			throw new UserIdNotFound("No user exists");
		}
	}

	@GetMapping("/getId")
	public ResponseEntity<Long> getId() {
		// check for status also if it is true then only get it
		return new ResponseEntity<>(currentUser.getId(), HttpStatus.FOUND);
	}
	
	

}
