package com.spring.ctech.shopease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ctech.shopease.entity.Customer;
import com.spring.ctech.shopease.entity.Order;
import com.spring.ctech.shopease.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("{customerId}/save")
	public String createOrder(@ModelAttribute Order theOrder, @PathVariable String customerId, Model theModel) {
		
		Customer theCustomer = orderService.createOrder(Integer.parseInt(customerId),theOrder);
		theModel.addAttribute("customer", theCustomer);
		return "customer-home";
	}
}
