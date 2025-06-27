package com.ccp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccp.entities.CreditCard;

@Repository("creditRepo")
public interface ICreditCardRepository extends JpaRepository<CreditCard, Long> {
	@Query(value = "select obj from CreditCard obj where obj.cardNumber=:#{#creditCard.cardNumber}")
	CreditCard addCreditCard(@Param("creditCard") CreditCard s);

	@Transactional
	@Modifying
	@Query(value = "delete from CreditCard Where id=?1")
	void removeCreditCard(long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE CreditCard SET  cardName = :#{#credit.cardName}, cardType = :#{#credit.cardType}, cardNumber= :#{#credit.cardNumber},expiryDate= :#{#credit.expiryDate},bankName= :#{#credit.bankName} WHERE id = :idx")
	void updateCreditCard(@Param("idx") long id, @Param("credit") CreditCard c);

	@Query(value = "select obj from CreditCard  obj where obj.id=?1")
	CreditCard getCreditCard(long id);

	@Query(value = "select obj from CreditCard  obj where obj.cardNumber=?1")
	CreditCard getCreditCardByNumber(String number);

	@Query(value = "select obj from CreditCard  obj")
	List<CreditCard> getAllCreditCards();

	// customer mapping
	@Query(value = "select obj.cardNumber from CreditCard  obj where obj.customer.userId=?1")
	List<String> getAllCreditCardsByCustomer(String userId);
}
