package com.tech.microservices.product.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tech.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

	Optional<Product> findByName(String name); // Find product by name
	
	void deleteByName(String name); // Delete product by name
	
	List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
}
