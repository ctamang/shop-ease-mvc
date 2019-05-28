package com.spring.ctech.shopease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ctech.shopease.entity.Customer;
import com.spring.ctech.shopease.entity.Order;
import com.spring.ctech.shopease.repository.CustomerRepository;
import com.spring.ctech.shopease.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer createOrder(int customerId, Order theOrder) {
		Customer customer = customerRepository.findById(customerId).get();
		customer.addOrder(theOrder);
		orderRepository.save(theOrder);
		return customer;
	}
}
