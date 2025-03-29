package com.tech.microservices.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tech.microservices.product.dto.ProductRequest;
import com.tech.microservices.product.dto.ProductResponse;
import com.tech.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
		return productService.createProduct(productRequest);
	}
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
//		try {
//			Thread.sleep(5000);
//		}
//		catch(InterruptedException e) {
//			throw new RuntimeException(e);
//		}
		return productService.getAllProducts();
	}
	
	@GetMapping("/by-name")
	@ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }
	
}
