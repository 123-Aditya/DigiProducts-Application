package com.tech.microservices.product.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.microservices.product.dto.ProductRequest;
import com.tech.microservices.product.dto.ProductResponse;
import com.tech.microservices.product.model.Product;
import com.tech.microservices.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	Logger log = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;
	
	public ProductResponse createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.name())
				.description(productRequest.description())
				.price(productRequest.price())
				.build();
		productRepository.save(product);
		log.info("Product created successfully!");
		
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

	public List<ProductResponse> getAllProducts() {
		log.info("Fetching all products...");
		return productRepository.findAll()
				.stream()
				.map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
				.toList();
	}
	
	public ProductResponse getProductByName(String name) {
	    log.info("Fetching product by name: {}", name);

	    return productRepository.findByName(name)
	            .map(product -> new ProductResponse(
	                    product.getId(),
	                    product.getName(),
	                    product.getDescription(),
	                    product.getPrice()
	            ))
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
	}

	public String deleteProductByName(String name) {
		Optional<Product> product = productRepository.findByName(name);
		if (product.isPresent()) {
			log.info("Deleting product by name: {}", name);
	        productRepository.deleteByName(name);
	        return "Product: " + name + " deleted successfully!";
	    } else {
	        return "Product: " + name + " not found!";
	    }
	}
}
