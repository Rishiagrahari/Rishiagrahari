package com.ccp.entities;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is the Credit Card entity
 * @author risagrah
 * @since 10-02-2023
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
@Id
@GeneratedValue
private long id;
@NotBlank(message="No card name provided")
private String cardName;
private String 	cardType;
@NotBlank(message="No card number name provided")
private String cardNumber;
@JsonFormat(pattern="yyyy-MM-dd")
private LocalDate expirtyDate;
private String bankName;
@ManyToOne
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Customer customer;
@OneToMany(cascade=CascadeType.ALL,mappedBy="creditCard")
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private List<Statement> statementList;
@Transient
private  static double totalBill=0;
@Transient
private static double totalUnBill=0;
public static void setTotalBill(double b) {
	totalBill=b;
}
public static void setTotalUnBill(double b) {
	totalUnBill=b;
}
public static double getTotalBill() {
	return totalBill;
}
public static double getTotalUnBill() {
	return totalUnBill;
}
public CreditCard(int id, String cardName, String cardType, String cardNumber, LocalDate expiryDate, String bankName) {
    this.id=id;
    this.cardName=cardName;
    this.cardType=cardType;
    this.cardNumber=cardNumber;
    this.expirtyDate=expiryDate;
    this.bankName=bankName;

}

}
