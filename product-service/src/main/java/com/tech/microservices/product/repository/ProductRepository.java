package com.tech.microservices.product.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tech.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

	Optional<Product> findByName(String name); // Find product by name
	
	void deleteByName(String name); // Delete product by name
}
