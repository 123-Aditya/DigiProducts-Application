package com.tech.microservices.product.dto;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String description, BigDecimal price, String brand, float rating) {
	
	
}
