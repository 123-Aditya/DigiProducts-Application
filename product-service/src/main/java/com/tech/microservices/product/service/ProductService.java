package com.tech.microservices.product.service;

import java.math.BigDecimal;
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
				.brand(productRequest.brand())
				.rating(productRequest.rating())
				.build();
		productRepository.save(product);
		log.info("Product created successfully!");
		
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getBrand(), product.getRating());
	}

	public List<ProductResponse> getAllProducts() {
		log.info("Fetching all products...");
		return productRepository.findAll()
				.stream()
				.map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getBrand(), product.getRating()))
				.toList();
	}
	
	public ProductResponse getProductByName(String name) {
	    log.info("Fetching product by name: {}", name);

	    return productRepository.findByName(name)
	            .map(product -> new ProductResponse(
	                    product.getId(),
	                    product.getName(),
	                    product.getDescription(),
	                    product.getPrice(),
	                    product.getBrand(),
	                    product.getRating()
	            ))
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
	}
	
	public List<ProductResponse> getProductByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
		log.info("Fetching all products between price range: {} and {}", minPrice, maxPrice);
		
		return productRepository.findByPriceBetween(minPrice, maxPrice)
				.stream()
				.map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getBrand(), product.getRating()))
				.toList();
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

	public String deleteAllProducts() {
		String message = null;
		log.info("Deleting all the products...");
		try {
			productRepository.deleteAll();
			message  = "All products deleted successfully";
		}
		catch(Exception e){
			log.error(e.getMessage());
			message = "Error occured while deleting all the products";
		}
		
		return message;
	}

}
