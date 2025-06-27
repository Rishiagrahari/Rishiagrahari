package com.ccp.service;

import java.util.Optional;

import com.ccp.entities.User;

public interface IUserService {
	public User signIn(User u);

	public User signOut(User u);

	public User changePassword(long id, User u);

	Optional<User> findByUserId(String userId);

	User save(User u);

}
