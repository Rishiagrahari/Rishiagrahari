package com.ccp.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.entities.CreditCard;
import com.ccp.entities.Statement;
import com.ccp.entities.Transaction;
import com.ccp.exceptions.CreditCardExpiredException;
import com.ccp.exceptions.NoTransactionException;
import com.ccp.repositories.ITransactionRepository;
import com.ccp.service.ICreditCardService;
import com.ccp.service.IStatementService;
import com.ccp.service.ITransactionService;

@Service("tranServ")
public class TransactionService implements ITransactionService{
	@Autowired
	private ITransactionRepository tranRepo;
	@Autowired
	private ICreditCardService ccRep;
	@Autowired
	private IStatementService ssServ;
    
	public Transaction addTransaction(Transaction t) {
		CreditCard creditCard =ccRep.getCreditCardByNumber(t.getCardNumber());
		String strId =creditCard.getId()+""+t.getCustomer().getId();
		long id = Long.parseLong(strId);
		if(creditCard.getExpirtyDate().isAfter(LocalDate.now())) {
			if(tranRepo.addTransaction(t)!=null)
				return null;//already exists
			else
			{
				tranRepo.save(t);
				if(t.getTranDate().isBefore(LocalDate.now())) {
				
//				totalAmount+=t.getAmount();
				Statement s = new Statement();
				s.setStatementId(id);
				s.setBillingDate(LocalDate.now());
				s.setDueDate(LocalDate.now().plusDays(15));
			    double total = CreditCard.getTotalBill()+t.getAmount();
			    CreditCard.setTotalBill(total);
			    s.setDueAmount(total);
				s.setCustomer(t.getCustomer());
		        s.setCreditCard(creditCard);
		        s.setStatus(true);
		        ssServ.addStatement(s);
		        return t;
				}
				else {

//					totalDue+=t.getAmount();
					Statement s = new Statement();
					s.setStatementId(id+1);
					s.setBillingDate(LocalDate.now().plusMonths(1));
					s.setDueDate(LocalDate.now().plusMonths(1).plusDays(15));
					 double total = CreditCard.getTotalUnBill()+t.getAmount();
					 CreditCard.setTotalUnBill(total);
					s.setDueAmount(total);
					s.setCustomer(t.getCustomer());
			        s.setCreditCard(creditCard);
			        s.setStatus(false);
			        ssServ.addStatement(s);
			        return t;
					
					
				}
				
			}
			
			}
		else
			throw new CreditCardExpiredException("Expired");
			
		}
		

	@Override
	public Transaction removeTransaction(long id) {
		Optional<Transaction> tranOp = tranRepo.findById(id);
		   if(tranOp.isPresent())
		   {
			  
		    tranRepo.removeTransaction(id);
		   return tranOp.get();
		}
		else {
			throw new NoTransactionException("No Transaction with given id");
		}
	}

	@Override
	public Transaction updateTransaction(long id, Transaction t) {
		 Optional<Transaction> tranOp = tranRepo.findById(id);
		   if(tranOp.isPresent())
		   {
			   tranRepo.updateTransaction(id, t);
				return t;
		   }
		   else
		   {
			   throw new NoTransactionException("Transaction not found");
		   }
	}

	@Override
	public Transaction getTransactionDetails(long id) {
		 Optional<Transaction> tranOp = tranRepo.findById(id);
		   if(tranOp.isPresent())
		   {
			 return tranRepo.getTransactionDetails(id);
		   }
		   else
		   {
			   throw new NoTransactionException("Transaction not found");
			   
		   }
	}

	@Override
	public List<Transaction> getAllTransactions() {
		if(tranRepo.getAllTransactions().isEmpty())
			{
			 throw new NoTransactionException("No Transactions exist");
			
			}
		else {
			return tranRepo.getAllTransactions();
		}
	}

	@Override
	public List<Transaction> getTransactionForCard(String cardNumber) {
		if(tranRepo.getTransactionForCard(cardNumber).isEmpty())
			{
			throw new NoTransactionException("No Transactions exist");
			
			}
			else
			{
				return tranRepo.getTransactionForCard(cardNumber);
			}
	}

	@Override
	public List<Transaction> getAllTransactionsByCustomer(long id,CreditCard c) {
		return tranRepo.getAllTransactionsByCustomer(id,c);
	}
	

}