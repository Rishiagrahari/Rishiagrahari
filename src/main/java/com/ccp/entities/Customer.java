package com.ccp.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is the Customer entity
 * @author risagrah
 * @since 10-02-2023
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {
	@NotBlank(message="No name provided")
	private String name;
	@Email(message ="invalid email")
	private String email;
	@NotBlank(message="No contact no provided")
	private String contactNo;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Address> addressList;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Transaction> transactionList;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Statement> statementList;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<CreditCard> creditCardList;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Account> accountList;
	
	public void setAddressList(List<Address>list){
		addressList=list;
		for(int i=0;i<addressList.size();i++) {
			addressList.get(i).setCustomer(this);
		}
		
	}
	public void setTransactionList(List<Transaction>list){
		transactionList=list;
		for(int i=0;i<transactionList.size();i++) {
			transactionList.get(i).setCustomer(this);
		}
		
	}
	public void setStatementList(List<Statement>list){
		statementList=list;
		for(int i=0;i<statementList.size();i++) {
			statementList.get(i).setCustomer(this);
		}
		
	}
	public void setCreditCardList(List<CreditCard>list){
		creditCardList=list;
		for(int i=0;i<creditCardList.size();i++) {
			creditCardList.get(i).setCustomer(this);
		}
		
	}
	
}
