package com.spring.ctech.shopease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ctech.shopease.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
