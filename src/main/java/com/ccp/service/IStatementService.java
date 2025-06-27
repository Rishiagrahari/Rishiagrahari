package com.ccp.service;

import java.util.List;

import com.ccp.entities.Customer;
import com.ccp.entities.Statement;

public interface IStatementService {

	public Statement addStatement(Statement s);

	public Statement removeStatement(long id);

	public Statement updateStatement(long id, Statement s);

	public Statement getStatement(long id);

	public List<Statement> getAllStatements();

	public List<Statement> getBilledStatement();

	public List<Statement> getUnbilledStatement();

	// customer mapping
	List<Statement> getCustomerStatement(Customer c);

}
