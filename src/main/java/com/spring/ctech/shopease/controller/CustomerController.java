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
import com.spring.ctech.shopease.entity.Order;
import com.spring.ctech.shopease.service.CustomerService;


@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/findAllCustomers")
	public String getAllcustomers(Model theModel){
		List<Customer> allCustomers = customerService.getAllcustomers();
		theModel.addAttribute("allCustomers", allCustomers);
		return "all-customers";
	}
	
	@GetMapping("/{id}")
	public String getcustomer(@PathVariable String id, Model theModel) {
		Customer customer = customerService.getcustomer(Integer.parseInt(id));
		theModel.addAttribute("customer", customer);
		return "customer-details";
	}
	
	@PostMapping("/save")
	public String  addcustomer(@ModelAttribute Customer customer, Model theModel) {
		customerService.addcustomer(customer);
		theModel.addAttribute("customer", customer);
		return "customer-home";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/")
	public void updatecustomer(@RequestBody Customer customer) {
		customerService.updatecustomer(customer);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deletecustomer(@PathVariable String id) {
		customerService.deletecustomer(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/query/{name}")
	public List<Customer> findByName(@PathVariable String name) {
		return customerService.findByName(name);
	}
	
	@GetMapping("{id}/addresses")
	public List<Address> getAddresses(@PathVariable String id){
		List<Address> addressList = customerService.findAddressesForCustomers(Integer.parseInt(id));
		return addressList;
	}
	
	@GetMapping("{customerId}/addAddress")
	public String addAddress(@PathVariable String customerId, Model theModel) {
		Customer theCustomer = customerService.getcustomer(Integer.parseInt(customerId));
		Address theAddress = new Address();
		theAddress.setCustomer(theCustomer);
		theModel.addAttribute("address", theAddress);
		return "address-form";
	}
	
	@GetMapping("/{customerId}/createOrder")
	public String createOrder(@PathVariable String customerId, Model theModel) {
		Customer theCustomer = customerService.getcustomer(Integer.parseInt(customerId));
		Order theOrder = new Order();
		theOrder.setCustomer(theCustomer);
		theModel.addAttribute("order", theOrder);
		theModel.addAttribute("customerId", customerId);
		return "order-form";
	}
}
