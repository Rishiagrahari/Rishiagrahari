package com.ccp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccp.entities.User;

@Repository("uRep")
public interface IUserRepository extends JpaRepository<User, Long> {

	@Query(value = "select obj from User obj where obj.userId=?1")
	Optional<User> findByUserId(String userId);

	@Query(value = "select obj from User obj where obj.password=?1")
	User findByPassword(String password);

	@Query(value = "select obj from User obj where obj.userId=:#{#user.userId}")
	User signIn(@Param("user") User u);

	@Query(value = "select obj from User obj where obj.userId=:#{#user.userId}")
	User signOut(@Param("user") User u);

	@Query(value = "select obj from User obj where obj.id= :id and obj.userId=:#{#user.userId}")
	User changePassword(@Param("id") long id, @Param("user") User u);

}
