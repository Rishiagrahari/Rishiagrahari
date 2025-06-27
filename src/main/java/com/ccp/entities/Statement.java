package com.ccp.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is the Statement entity
 * @author risagrah
 * @since 10-02-2023
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Statement {
	@Id
	private long statementId;
	private double dueAmount;
	private LocalDate billingDate;
	private LocalDate dueDate;
	private boolean status;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Customer customer;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="statement")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Payment> paymentList;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private CreditCard creditCard;
	
public Statement(int statementId, double dueAmount, LocalDate billingDate, LocalDate dueDate, boolean status) {
	this.statementId=statementId;
	this.dueAmount=dueAmount;
	this.billingDate=billingDate;
	this.dueDate=dueDate;
	this.status=status;
		
	}
	

}
