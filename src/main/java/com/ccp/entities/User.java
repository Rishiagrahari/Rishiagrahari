package com.ccp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is the User entity
 * @author risagrah
 * @since 10-02-2023
 *
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="userDetails")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue
	private long id;
	@NotBlank(message="No userId provided")
	private String userId;
	@NotBlank(message="password cannot be empty")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private boolean status;
	public User(int id, String userId, String password, boolean status) {
		this.id=id;
		this.userId=userId;
		this.password=password;
		this.status=status;
	}
}
