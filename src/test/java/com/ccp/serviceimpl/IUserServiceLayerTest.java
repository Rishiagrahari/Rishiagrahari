package com.ccp.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccp.entities.User;
import com.ccp.repositories.IUserRepository;
import com.ccp.service.IUserService;
@SpringBootTest
public class IUserServiceLayerTest {
	@Autowired 
	private UserService service;
	@MockBean
	private IUserRepository rep;
	  @Test
	  public void testSignIn() {
		  User user = new User(1,"Rishi","Rasi123",true);
		  when(rep.signIn(user)).thenReturn(user);
		  assertEquals(user,rep.signIn(user));
	  }
		  
	  @Test
	  public void testSignOut() {
		  User user = new User(1,"Rishi","Rashi123",false);
		  when(rep.signOut(user)).thenReturn(user);
		  assertEquals(user,service.signOut(user));
	  }
	  @Test
	  public void testChangePassword() {
	    long id = 1;
	    User user = new User(1,"Rishi","Rashi145",true);
	    when(rep.changePassword(id, user)).thenReturn(user);
	    User returnedUser = service.changePassword(id, user);
	    assertEquals(user, returnedUser);
	  }

	  @Test
	  public void testFindByUserId() {
		User user = new User(1,"Rishi","Rashi145",true);
		long id = 1;
	    when(rep.findByUserId("Rishi")).thenReturn(Optional.of(user));
	    Optional<User> returnedUser = service.findByUserId("Rishi");
	    assertEquals(user, returnedUser.get());
	  }
//	  @Test
//	  public void testSave() {
//	    when(userRepository.save(testUser)).thenReturn(testUser);
//	    User returnedUser = userService.save(testUser);
//	    assertEquals(testUser, returnedUser);
//	  }
	}
	
