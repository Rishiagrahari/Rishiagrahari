package com.ccp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.entities.Customer;
import com.ccp.entities.Statement;
import com.ccp.entities.Transaction;
import com.ccp.exceptions.NoStatementException;
import com.ccp.exceptions.NoTransactionException;
import com.ccp.repositories.IStatementRepository;
import com.ccp.repositories.ITransactionRepository;
import com.ccp.service.ICreditCardService;
import com.ccp.service.IStatementService;

@Service("statementServ")
public class StatementService implements IStatementService {
	@Autowired
	private IStatementRepository statementRepo;
	@Autowired
	private ITransactionRepository tranRepo;
	@Autowired
	ICreditCardService creditServ;


	public Statement addStatement(Statement s) {

		Statement cc = statementRepo.addStatement(s);
		if (cc != null) {
			{
				return updateStatement(s.getStatementId(), s);
			}
		} else {
			statementRepo.save(s);
			return s;
		}

	}

	public List<Transaction> getTransactions() {
		if (tranRepo.findAll().isEmpty())
			throw new NoTransactionException("No Transactions exist");
		else {
			return tranRepo.findAll();
		}
	}

	public Statement updateStatement(long id, Statement s) {
		Optional<Statement> tranOp = statementRepo.findById(id);
		if (tranOp.isPresent()) {

			statementRepo.updateStatement(id, s);
			return tranOp.get();
		} else
		{
			throw new NoStatementException("No Transaction with given id");
		}

	}

	@Override
	public Statement removeStatement(long id) {
		Optional<Statement> tranOp = statementRepo.findById(id);
		if (tranOp.isPresent()) {

			statementRepo.removeStatement(id);
			return tranOp.get();
		} else
			throw new NoStatementException("No Transaction with given id");
	}

	@Override
	public Statement getStatement(long id) {
		if(statementRepo.getStatement(id)==null)
			throw new NoStatementException("No Transaction with given id");
		else
			return statementRepo.getStatement(id);
	}

	@Override
	public List<Statement> getAllStatements() {
		if(statementRepo.getAllStatements().isEmpty())
			throw new NoStatementException("No Transactions");
		else
			return statementRepo.getAllStatements();
	}

	@Override
	public List<Statement> getBilledStatement() {
		if(statementRepo.getBilledStatement().isEmpty())
			throw new NoStatementException("No Billed Transaction");
		else
			return statementRepo.getBilledStatement();
	}

	@Override
	public List<Statement> getUnbilledStatement() {
		if(statementRepo.getUnbilledStatement().isEmpty())
			throw new NoStatementException("No Unbilled Transaction");
		else
			return statementRepo.getUnbilledStatement();
	}

	@Override
	public List<Statement> getCustomerStatement(Customer c) {
		return statementRepo.getCustomerStatement(c);

	}

}