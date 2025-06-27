package com.ccp.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is the Address entity
 * @author risagrah
 * @since 10-02-2023
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue
	private long id;
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private int pincode;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Customer customer;
	public Address(int id, String doorNo, String street, String area, String city, String state, int pincode) {
	this.id=id;
	this.doorNo=doorNo;
	this.street=street;
	this.area=area;
	this.city=city;
	this.state=state;
	this.pincode=pincode;
	
	
	}
}
