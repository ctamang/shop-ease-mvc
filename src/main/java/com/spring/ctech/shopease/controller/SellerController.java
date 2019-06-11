package com.spring.ctech.shopease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ctech.shopease.entity.Address;
import com.spring.ctech.shopease.entity.Seller;
import com.spring.ctech.shopease.service.SellerService;

@Controller
@RequestMapping("/seller")
public class SellerController {
		
	@Autowired 
	SellerService sellerService;
	
	@PostMapping("/save")
	public String saveSeller(@ModelAttribute Seller theSeller, Model theModel) {
		sellerService.saveSellerInformtaion(theSeller);
		theModel.addAttribute("seller", theSeller);
		return "seller-info-page";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model theModel) {
		theModel.addAttribute("seller", new Seller());
		return "seller-login";
	}
	
	@GetMapping("/registration")
	public String getLoggingPageForSeller(Model theModel) {
		theModel.addAttribute("seller", new Seller());
		return "seller-registration-form";
	}
	
	@GetMapping("{sellerId}/showSellerAddressRegistrationPage")
	public String showSellerAddressRegistrationPage(@PathVariable Integer sellerId, Model theModel) {
		theModel.addAttribute("sellerId", sellerId);
		theModel.addAttribute("address", new Address());
		return "seller-address-form";
	}
	
	@PostMapping("/authenticateSeller")
	public String authenticateUser(@ModelAttribute Seller seller, Model theModel) {
	
		String inputUserName = seller.getEmail();
		String inputUserPassword = seller.getPassword();
		Seller SellerDetails = sellerService.findSeller(seller.getEmail());
		if(SellerDetails.getEmail().equalsIgnoreCase(inputUserName) 
				&& SellerDetails.getPassword().equalsIgnoreCase(inputUserPassword)) {
			theModel.addAttribute("seller", SellerDetails);
			return "seller-info-page";
		}
		return "seller-login";
	}
}
