package com.spring.ctech.shopease.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	
	private String orderDescription;
	
	//private List<Item> itemsList;
	@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	private String orderTotal;
	
	public Order() {}
	public Order(String orderDescription, String orderTotal) {
		super();
		this.orderDescription = orderDescription;
		this.orderTotal = orderTotal;
	}

	public Order(String orderDescription, Customer customer, String orderTotal) {
		super();
		this.orderDescription = orderDescription;
		this.customer = customer;
		this.orderTotal = orderTotal;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public String getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Integer getOrderId() {
		return orderId;
	}
}
