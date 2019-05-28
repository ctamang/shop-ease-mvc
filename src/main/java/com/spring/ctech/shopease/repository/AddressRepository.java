package com.spring.ctech.shopease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ctech.shopease.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
}
