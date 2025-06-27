package com.ccp.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.entities.User;
import com.ccp.repositories.IUserRepository;
import com.ccp.service.IUserService;

@Service("userServ")
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepo;
	@Override
	public User signIn(User u) {
		return userRepo.signIn(u);
	}

	@Override
	public User signOut(User u) {
		return userRepo.signOut(u);
	}

	@Override
	public User changePassword(long id, User u) {
		return userRepo.changePassword(id, u);
	}

	@Override
	public Optional<User> findByUserId(String userId) {
		return userRepo.findByUserId(userId);
	}

	@Override
	public User save(User u) {
		return userRepo.save(u);
	}
        
	
	
	
}
