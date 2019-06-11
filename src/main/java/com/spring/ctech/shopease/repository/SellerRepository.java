package com.spring.ctech.shopease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ctech.shopease.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

	Seller findByEmail(String email);
}