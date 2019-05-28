package com.spring.ctech.shopease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ctech.shopease.entity.Customer;
import com.spring.ctech.shopease.service.CustomerService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/")
	public String getLoginPage(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "login";
	}
	
	@GetMapping("/authenticateUser")
	public String authenticateUser(@ModelAttribute Customer customer, Model theModel) {
	
		String inputUserName = customer.getEmail();
		String inputUserPassword = customer.getPassword();
		Customer customerDetails = customerService.getcustomer(customer.getCustomerId());
		
		if(customerDetails.getEmail().equalsIgnoreCase(inputUserName) 
				&& customerDetails.getPassword().equalsIgnoreCase(inputUserPassword)) {
			return "customer-home";
		}
		return "login";
	}
	
}
