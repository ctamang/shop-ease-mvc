package com.spring.ctech.shopease.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ctech.shopease.entity.Address;
import com.spring.ctech.shopease.entity.Seller;
import com.spring.ctech.shopease.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	SellerRepository sellerRepository;
	
	public void saveSellerInformtaion(Seller seller) {
		sellerRepository.save(seller);
	}
//	public void saveSellerAddress(Address address) {
//		
//		addressRepository.save(address);
//	}
	
	public Seller findSeller(String email) {
		Seller findById = sellerRepository.findByEmail(email);
		if(findById != null) {
			return findById;
		}
		return new Seller();
	}
}
