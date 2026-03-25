package com.foodservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodservice.service.DeliveryService;

import jakarta.persistence.criteria.Order;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    // Assigning the driver
    @PutMapping("/assign/{orderId}/{driverId}")
    public ResponseEntity<Order> assignDriver(@PathVariable Long orderId, @PathVariable Long driverId) {
        return ResponseEntity.ok(deliveryService.assignDriver(orderId, driverId));
    }

    // Update the status of the order
    @PutMapping("/status/{orderId}")
    public ResponseEntity<Order> updateStatus(@PathVariable Long orderId, @RequestParam String status) {
    
	    OrderEntity order = service.updateOrderStatus(orderId);
	    OrderResponseDTO response = OrderMapper.convertEntityToDto(order);

	    return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
