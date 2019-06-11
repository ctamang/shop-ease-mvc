package com.spring.ctech.shopease.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ctech.shopease.entity.Address;
import com.spring.ctech.shopease.entity.Customer;
import com.spring.ctech.shopease.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllcustomers() {
		return customerRepository.findAll();
	}

	public Customer getcustomer(Integer id) {
		return customerRepository.findById(id).get();
	}

	public void addcustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
//	public void addAddress(Integer customerId) {
//		Customer customer = customerRepository.findById(customerId).get();
//		customer.add
//	}
	
	public void updatecustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void deletecustomer(String id) {
		// TODO Auto-generated method stub
		
	}

	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Address> findAddressesForCustomers(int id) {
		Optional<Customer> findById = customerRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get().getAddress();
		}
		return new HashSet<Address>();
	}

	public Customer getcustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	
}
