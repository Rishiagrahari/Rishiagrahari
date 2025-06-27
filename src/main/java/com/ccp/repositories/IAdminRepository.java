package com.ccp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccp.entities.Admin;

@Repository("adminRepo")
public interface IAdminRepository extends JpaRepository<Admin, Long> {
	@Query(value = "select obj from Admin obj where obj.userId=:#{#admin.userId}")
	Admin addAdmin(@Param("admin") Admin c);

	@Transactional
	@Modifying
	@Query(value = "delete from Admin Where id=?1")
	void removeAdmin(long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Admin SET  userId= :#{#admin.userId}, password = :#{#admin.password} where id=:id")
	void updateAdmin(@Param("id") long id, @Param("admin") Admin a);

	@Query(value = "select obj from Admin obj where obj.id=?1")
	Admin getAdmin(long id);

	@Query(value = "select obj from Admin obj")
	List<Admin> getAllAdmins();
}
