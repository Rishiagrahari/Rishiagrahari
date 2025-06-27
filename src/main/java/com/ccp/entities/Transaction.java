package com.ccp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is the Transaction entity
 * @author risagrah
 * @since 10-02-2023
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue
	private long tranId;
	private String cardNumber;
	private LocalDate tranDate;
	private String status;
//	@Min(value)
	private double amount;
	private String paymentMethod;
	private String description;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Customer customer;
	
	public Transaction(int tranId, String cardNumber, LocalDate tranDate, String status, double amount, String paymentMethod, String description) {
		this.tranId=tranId;
		this.cardNumber=cardNumber;
		this.tranDate=tranDate;
		this.status=status;
		this.amount=amount;
		this.paymentMethod=paymentMethod;
		this.description=description;

	
	
	}
}
