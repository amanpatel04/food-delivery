package com.foodservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.entity.DeliveryDriver;
import com.foodservice.respository.DeliveryDriverRepository;
import com.foodservice.respository.orderRepository;

import jakarta.persistence.criteria.Order;

@Service
public class DeliveryService {
	@Autowired
	private OrderRepository repo;
	
	@Autowired
    private DeliveryDriverRepository driverRepository;

    // Assign the driver to order
    public Order assignDriver(Long orderId, Long driverId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        DeliveryDriver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        order.setDeliveryDriver(driver);
        order.setOrderStatus("OUT_FOR_DELIVERY");

        return orderRepository.save(order);
    }

    // Update the order status
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setOrderStatus(status);
        return orderRepository.save(order);
    }
}	
