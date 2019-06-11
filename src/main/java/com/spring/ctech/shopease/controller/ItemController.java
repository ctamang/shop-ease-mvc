package com.spring.ctech.shopease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ctech.shopease.entity.Item;
import com.spring.ctech.shopease.entity.Seller;
import com.spring.ctech.shopease.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("{sellerId}/showAddItemsPage")
	public String ShowAddItemsPage(@PathVariable Integer sellerId, Model theModel) {
		theModel.addAttribute("item", new Item());
		theModel.addAttribute("sellerId", sellerId);
		return "item-form";
	}
	
	@PostMapping("{sellerId}/save")
	public String addItem(@ModelAttribute Item theItem, @PathVariable Integer sellerId, Model theModel) {
		Seller theSeller = itemService.addItem(sellerId, theItem);
		theModel.addAttribute("seller", theSeller);
		return "seller-info-page";
	}
	
	@GetMapping("{sellerId}/{item}/searchItem")
	public String searchItem(@PathVariable Integer sellerId, @PathVariable String item, Model theModel) {
		List<Item> searchedItems = itemService.searchItem(sellerId, item);
		return "seller-info-page";
	}
}
