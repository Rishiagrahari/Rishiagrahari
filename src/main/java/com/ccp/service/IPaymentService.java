package com.ccp.service;

import java.util.List;

import com.ccp.entities.Payment;

public interface IPaymentService {

	public Payment addPayment(Payment p);

	public Payment removePayment(long id);

	public Payment updatePayment(long id, Payment p);

	public Payment getPayment(long id);

	public List<Payment> getAllPayments();

}
