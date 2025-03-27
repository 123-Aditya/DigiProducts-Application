package com.tech.microservices.inventory.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tech.microservices.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	
	Logger log = LoggerFactory.getLogger(InventoryService.class);

	@Autowired
	private InventoryRepository inventoryRepository;

	public boolean isInStock(String skuCode, Integer quantity) {
		// Find an inventory for a given skuCode where quantity >= 0
		log.info("Fetching product information from Inventory...");
		return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode ,quantity);
	}
}
