package com.carpark.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.carpark.metamodel.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Partner extends AbstractEntity {

	private String name;
	private String phoneNumber;
	@Column(unique = true)
	private String Email;
	private String Address;
	private String Type;

	public Partner() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
}
