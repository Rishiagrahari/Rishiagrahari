package com.ccp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.entities.Account;

import com.ccp.entities.CreditCard;
import com.ccp.entities.Payment;
import com.ccp.entities.Statement;
import com.ccp.exceptions.InsufficientBalanceException;
import com.ccp.exceptions.NoPaymentException;
import com.ccp.repositories.IPaymentRepository;
import com.ccp.service.IAccountService;
import com.ccp.service.IPaymentService;
import com.ccp.service.IStatementService;

@Service("payServ")
public class PaymentService implements IPaymentService{
	@Autowired
	private IPaymentRepository payRepo;
	@Autowired
	private IStatementService statmServ;
	@Autowired
	private IAccountService acctServ;
	
	@Override
	public Payment addPayment(Payment p) {
		if(acctServ.getAccount(p.getAccount().getAccountId()).getBalance()>p.getAmountDue()) {
			if(payRepo.addPayment(p)!=null)
			{
				return updatePayment(p.getPaymentId(), p);
			}
			else
			{
				payRepo.save(p);
				Statement s = statmServ.getStatement(p.getStatement().getStatementId());
				s.setDueAmount(s.getDueAmount()-p.getAmountDue());
				CreditCard.setTotalBill(s.getDueAmount()-p.getAmountDue());
				statmServ.updateStatement(s.getStatementId(), s);
				Account a = acctServ.getAccount(p.getAccount().getAccountId());
				a.setBalance(a.getBalance()-p.getAmountDue());
				acctServ.updateAccount(a.getAccountId(), a);
				return p;
			}
			
		}
		else {
		throw new InsufficientBalanceException("No balance or less balance");
		}
	}

	@Override
	public Payment removePayment(long id) {
		Optional<Payment> payOp = payRepo.findById(id);
		   if(payOp.isPresent())
		   {
			   payRepo.removePayment(id);
				return payOp.get();
		   }
		   else {
			throw new NoPaymentException("No Payment with given id");
		   }
	}

	@Override
	public Payment updatePayment(long id, Payment p) {
		Optional<Payment> payOp = payRepo.findById(id);
		   if(payOp.isPresent())
		   {
			   payRepo.updatePayment(id, p);
				return p;
		   }
		   else
		   {
			   throw new NoPaymentException("Payment not found");
		   }
		
	}

	@Override
	public Payment getPayment(long id) {
		if(payRepo.getPayment(id)==null)
			throw new NoPaymentException("No Payment with given id");
		else
		{
			return payRepo.getPayment(id);
		}
	}

	@Override
	public List<Payment> getAllPayments() {
		if(payRepo.getAllPayments().isEmpty())
			throw new NoPaymentException("No Payments exist");
		else
		{
			return payRepo.getAllPayments();
		}
	}
	

}