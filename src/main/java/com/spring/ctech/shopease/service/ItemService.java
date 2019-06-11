package com.spring.ctech.shopease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ctech.customQueriesJPQL.ItemQueries;
import com.spring.ctech.shopease.entity.Item;
import com.spring.ctech.shopease.entity.Seller;
import com.spring.ctech.shopease.repository.ItemRepository;
import com.spring.ctech.shopease.repository.SellerRepository;

@Service
public class ItemService {
	
	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired 
	ItemQueries itemQueries;
	
	public Seller addItem(Integer sellerId, Item theItem) {
		Seller theSeller = sellerRepository.findById(sellerId).get();
		theSeller.addItem(theItem);
		itemRepository.save(theItem);
		return theSeller;
	}
	
	public List<Item> searchItem(Integer sellerId, String itemName) {
		Seller theSeller = sellerRepository.findById(sellerId).get();
		List<Item> searchedItem = itemQueries.findItemUsingItemName(itemName);
		searchedItem.forEach(item -> theSeller.addItem(item));
		return searchedItem;
	}
}
