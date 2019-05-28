package com.spring.ctech.shopease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ctech.shopease.entity.Address;
import com.spring.ctech.shopease.entity.Customer;
import com.spring.ctech.shopease.repository.AddressRepository;
import com.spring.ctech.shopease.repository.CustomerRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Address> getAllAddresss() {
		return addressRepository.findAll();
	}

	public Address getAddress(int addressId) {
		return addressRepository.findById(addressId).get();
	}

	public Customer addAddress(int customerId, Address address) {
		Customer customer = customerRepository.findById(customerId).get();
		customer.addAddress(address);
		addressRepository.save(address);
		return customer;
	}

	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAddress(String id) {
		// TODO Auto-generated method stub
		
	}

	public List<Address> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
