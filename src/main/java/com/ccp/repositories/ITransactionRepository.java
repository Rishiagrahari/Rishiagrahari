package com.ccp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccp.entities.CreditCard;
import com.ccp.entities.Transaction;

@Repository("tranRepo")
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
	@Query(value = "select obj from Transaction obj where obj.tranId=:#{#transaction.tranId}")
	Transaction addTransaction(@Param("transaction") Transaction t);

	@Transactional
	@Modifying
	@Query(value = "delete from Transaction Where tranId=?1")
	void removeTransaction(long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Transaction SET  cardNumber= :#{#transaction.cardNumber}, tranDate = :#{#transaction.tranDate}, status= :#{#transaction.status},amount= :#{#transaction.amount},paymentMethod= :#{#transaction.paymentMethod},description= :#{#transaction.description} WHERE tranId = :id")
	void updateTransaction(@Param("id") long id, @Param("transaction") Transaction t);

	@Query(value = "select obj from Transaction obj where obj.tranId=?1")
	Transaction getTransactionDetails(long id);

	@Query(value = "select obj from Transaction obj")
	List<Transaction> getAllTransactions();

	//customer mapping
	@Query(value = "select obj from Transaction obj where obj.cardNumber=?1")
	List<Transaction> getTransactionForCard(String cardNumber);

	@Query(value = "select obj from Transaction obj where obj.customer.id=?1 and obj.cardNumber=:#{#card.cardNumber}")
	List<Transaction> getAllTransactionsByCustomer(long id, @Param("card") CreditCard c);
}
