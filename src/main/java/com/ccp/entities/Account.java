package com.ccp.entities;

import java.util.List;import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is the Account entity
 * @author risagrah
 * @since 10-02-2023
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Account {
	@Id
	@GeneratedValue
	private long accountId;
	private String accountName;
	@Min(value=100,message="Minimum balance of Rs 100 should be maintained")
	private double balance;
	private String accountType;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Customer customer;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="account")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Payment> paymentList;
	
	public void setPaymentList(List<Payment>list){
		paymentList=list;
		for(int i=0;i<paymentList.size();i++) {
			paymentList.get(i).setAccount(this);
		}
		
	}
	public Account(long id, String accountName, double balance, String accountType) {
		this.accountId=id;
		this.accountName=accountName;
		this.balance = balance;
		this.accountType=accountType;
	}

}
