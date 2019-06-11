package com.spring.ctech.shopease.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sellerId;
	
	private String firstName;
	
	private String lastName;
	
	private String sellerOfficeName;
	
	private String email;
	
	private String password;
	
	private String contactNumber;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="seller", cascade=CascadeType.ALL)
	private Address address;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="seller", cascade=CascadeType.ALL)
	private List<Item> item = new ArrayList<>();

	public Seller() {}
	
	public Seller(String firstName, String lastName, String sellerOfficeName, String email, String password,
			String contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sellerOfficeName = sellerOfficeName;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
	}

	public Seller(String firstName, String lastName, String sellerOfficeName, String email, String password,
			String contactNumber, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sellerOfficeName = sellerOfficeName;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.address = address;
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

	public String getSellerOfficeName() {
		return sellerOfficeName;
	}
	public void setSellerOfficeName(String sellerOfficeName) {
		this.sellerOfficeName = sellerOfficeName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
		address.setSeller(this);
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public void addItem(Item theItem) {
		this.item.add(theItem);
		theItem.setSeller(this);
	}
	
}
