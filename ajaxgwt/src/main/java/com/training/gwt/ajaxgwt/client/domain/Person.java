package com.training.gwt.ajaxgwt.client.domain;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Person implements IsSerializable {

	private String firstName;
	private String lastName;
	
	public Person() {
		super();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
