package com.spring.ctech.customQueriesJPQL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ctech.shopease.entity.Item;

@Transactional
@Service
public class ItemQueries {

	@Autowired
	EntityManager entityManager;
	
	public List<Item> findItemUsingItemName(String itemName) {
		TypedQuery<Item> query = entityManager.createNamedQuery("select i from Item i where i.itemName like '%" + itemName + "%'", Item.class);
		query.setParameter("itemName", itemName);
		List<Item> resultList = query.getResultList();
		return resultList;
	}
}
