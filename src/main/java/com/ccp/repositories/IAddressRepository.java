package com.ccp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccp.entities.Address;

@Repository("addRepo")
public interface IAddressRepository extends JpaRepository<Address, Long> {
	@Query(value = "select obj from Address obj where obj.id=:#{#address.id}")
	Address addAddress(@Param("address") Address a);

	@Transactional
	@Modifying
	@Query(value = "delete from Address Where id=?1")
	void removeAddress(long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Address SET  doorNo= :#{#address.doorNo},street= :#{#address.street},area= :#{#address.area},city= :#{#address.city},state= :#{#address.state},pincode= :#{#address.pincode} WHERE id = :id")
	void updateAddress(@Param("id") long id, @Param("address") Address a);

	@Query(value = "select obj from Address obj where obj.id=?1")
	Address getAddress(long id);

	@Query(value = "select obj from Address obj")
	List<Address> getAllAddress();
}
