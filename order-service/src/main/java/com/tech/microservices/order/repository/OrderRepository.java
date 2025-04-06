package com.tech.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.microservices.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
