package com.spring.ctech.shopease.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	private String password;
	private String contactNumber; 
	
	@OneToMany(fetch=FetchType.LAZY,  mappedBy="customer", cascade=CascadeType.ALL)
	private Set<Order> order;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer", cascade=CascadeType.ALL)
	private Set<Address> address;
	
	public Customer() {
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	public Customer(String firstName, String lastName, String email, String contactNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
	}
	
	public Customer(Integer customerId, String firstName, String lastName, String email, String contactNumber) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public Set<Address> getAddress() {
		return address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public void addAddress(Address tempAddress) {
		if(address == null) {
			address = new HashSet<>();
		}
		address.add(tempAddress);
		tempAddress.setCustomer(this);
	}
	
	public void addOrder(Order theOrder) {
		if(order == null) {
			order = new HashSet<>();
		}
		order.add(theOrder);
		theOrder.setCustomer(this);
	}
}

