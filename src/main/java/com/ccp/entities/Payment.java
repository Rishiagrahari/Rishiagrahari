package com.ccp.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is the Payment entity
 * @author risagrah
 * @since 10-02-2023
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Payment {
	@Id
	@GeneratedValue
	private long paymentId;
	private String method;
//	@Min(value)
	private double amountDue;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Account account;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Statement statement;
	public Payment(long paymentId, String method, double amountDue) {
		this.paymentId=paymentId;
		this.method=method;
		this.amountDue=amountDue;
	}

}
