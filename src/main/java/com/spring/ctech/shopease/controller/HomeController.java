package com.spring.ctech.shopease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.ctech.shopease.entity.Customer;
import com.spring.ctech.shopease.service.CustomerService;

@Controller
public class HomeController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public String getHome(Model theModel) {
		return "home";
	}
	
	@GetMapping("/registration")
	public String getRegister(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "registration-form";
	}
	
	@GetMapping("/login")
	public String getLogin(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "login";
	}
	
	@PostMapping("/authenticateUser")
	public String authenticateUser(@ModelAttribute Customer customer, Model theModel) {
	
		String inputUserName = customer.getEmail();
		String inputUserPassword = customer.getPassword();
		Customer customerDetails = customerService.getcustomerByEmail(customer.getEmail());
		
		if(customerDetails.getEmail().equalsIgnoreCase(inputUserName) 
				&& customerDetails.getPassword().equalsIgnoreCase(inputUserPassword)) {
			theModel.addAttribute("customer", customerDetails);
			return "customer-home";
		}
		
		return "login";
	}
}
