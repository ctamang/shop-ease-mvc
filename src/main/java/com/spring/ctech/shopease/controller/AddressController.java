package com.spring.ctech.shopease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ctech.shopease.entity.Address;
import com.spring.ctech.shopease.entity.Customer;
import com.spring.ctech.shopease.service.AddressService;

@Controller
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("")
	public List<Address> getAllAddresss(){
		return addressService.getAllAddresss();
	}
	
	@GetMapping("/{id}")
	public Address getAddress(@PathVariable String id) {
		return addressService.getAddress(Integer.parseInt(id));
	}
	
	@PostMapping("/{custId}/save")
	public String addAddress(@ModelAttribute Address Address, @PathVariable String custId, Model theModel) {
		Customer customer = addressService.addAddress(Integer.parseInt(custId), Address);
		theModel.addAttribute("customer", customer);
		return "customer-home";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/")
	public void updateAddress(@RequestBody Address Address) {
		addressService.updateAddress(Address);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteAddress(@PathVariable String id) {
		addressService.deleteAddress(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/query/{name}")
	public List<Address> findByName(@PathVariable String name) {
		return addressService.findByName(name);
	}
}
