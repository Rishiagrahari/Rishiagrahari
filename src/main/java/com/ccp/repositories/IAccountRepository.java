package com.ccp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccp.entities.Account;

@Repository("accountRepo")
public interface IAccountRepository extends JpaRepository<Account, Long> {

	@Query("select obj.balance from Account obj where obj.customer.id=?1")
	double getAccountOnUser(long id);

	@Query(value = "select obj from Account obj where obj.accountId=:#{#account.accountId}")
	Account addAccount(@Param("account") Account a);

	@Transactional
	@Modifying
	@Query(value = "delete from Account Where accountId=?1")
	void removeAccount(long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Account SET  accountName = :#{#account.accountName}, balance = :#{#account.balance}, accountType= :#{#account.accountType} WHERE accountId = :id")
	void updateAccount(@Param("id") long id, @Param("account") Account a);

	@Query(value = "select obj from Account obj where obj.accountId=?1")
	Account getAccount(long id);

	@Query(value = "select obj from Account obj")
	List<Account> getAllAccounts();
}
