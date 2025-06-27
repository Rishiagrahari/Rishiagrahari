package com.ccp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccp.entities.Payment;



@Repository("paymentRepo")
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

	@Query(value = "select obj from Payment obj where obj.paymentId=:#{#payment.paymentId}")
	Payment addPayment(@Param("payment") Payment t);

	@Transactional
	@Modifying
	@Query(value = "delete from Payment Where paymentId=?1")
	void removePayment(long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Payment SET  method= :#{#payment.method},amountDue = :#{#payment.amountDue} WHERE paymentId = :id")
	void updatePayment(@Param("id") long id, @Param("payment") Payment t);

	@Query(value = "select obj from Payment obj where obj.paymentId=?1")
	Payment getPayment(long id);

	@Query(value = "select obj from Payment obj")
	List<Payment> getAllPayments();

}
