package com.tech.microservices.order.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.microservices.order.dto.OrderRequest;
import com.tech.microservices.order.model.Order;
import com.tech.microservices.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		// map orderRequest to Order object
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setPrice(orderRequest.price());
		order.setQuantity(orderRequest.quantity());
		order.setSkuCode(orderRequest.skuCode());
		
		// save order to orderRepository
		orderRepository.save(order);
	}
	
}
