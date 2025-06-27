package com.ccp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccp.entities.Address;
import com.ccp.entities.Customer;


@Repository("customerRepo")
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "select obj from Customer obj where obj.userId=:name")
	Customer findByUserId(@Param("name") String userId);

	@Query(value = "select obj from Customer obj where obj.userId=:#{#customer.userId}")
	Customer addCustomer(@Param("customer") Customer c);

	@Query(value = "select obj from Customer obj where obj.id=?1")
	Customer removeCustomer(long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Customer SET userId = :#{#customer.userId}, name = :#{#customer.name}, email = :#{#customer.email}, contactNo= :#{#customer.contactNo}, dob = :#{#customer.dob} WHERE id = :id")
	void updateCustomer(@Param("id") long id, @Param("customer") Customer c);

	@Query(value = "select obj from Customer obj where obj.id=?1")
	Customer getCustomer(long id);

	@Query(value = "select obj from Customer obj")
	List<Customer> getAllCustomers();

	@Query(value = "select obj from Address obj  where obj.customer.userId=?1")
	List<Address> getAllAddress(String userId);

}
