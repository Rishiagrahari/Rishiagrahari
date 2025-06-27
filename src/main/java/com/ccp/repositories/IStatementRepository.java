package com.ccp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ccp.entities.Customer;
import com.ccp.entities.Statement;

@Repository("statementRepo")
public interface IStatementRepository extends JpaRepository<Statement, Long> {
	@Query(value = "select obj from Statement obj where obj.status=true")
	List<Statement> getBilledStatement();

	@Query(value = "select obj from Statement obj where obj.status=false")
	List<Statement> getUnbilledStatement();

	@Query(value = "select obj from Statement obj where obj.statementId=:#{#statement.statementId}")
	Statement addStatement(@Param("statement") Statement s);

	@Transactional
	@Modifying
	@Query(value = "delete from Statement Where statementId=?1")
	void removeStatement(long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Statement SET  dueAmount = :#{#statement.dueAmount}, billingDate = :#{#statement.billingDate}, dueDate= :#{#statement.dueDate} WHERE statementId = :id")
	void updateStatement(@Param("id") long id, @Param("statement") Statement s);

	@Query(value = "select obj from Statement obj where obj.statementId=?1")
	Statement getStatement(long id);

	@Query(value = "select obj from Statement obj")
	List<Statement> getAllStatements();

	// credi card and customer mapping
	@Query("select obj from Statement obj where obj.customer.id=:#{#g.id}")
	List<Statement> getCustomerStatement(@Param("g") Customer c);

}
