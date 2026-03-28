package com.foodservice.controller;

import com.foodservice.entity.dto.CustomerDTO;
import com.foodservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    // Get single customer
    @GetMapping("/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable Integer customerId) {
        return service.getCustomerById(customerId);
    }

    // Get all customers
    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return service.getAllCustomers();
    }

    // Get customers by city
    @GetMapping("/city")
    public List<CustomerDTO> getCustomersByCity(@RequestParam String city) {
        return service.getCustomersByCity(city);
    }

    // Get address count for a customer
    @GetMapping("/{customerId}/address-count")
    public int getAddressCount(@PathVariable Integer customerId) {
        return service.getAddressCount(customerId);
    }

    // Get customer analytics
    @GetMapping("/{customerId}/analytics")
    public Object getCustomerAnalytics(@PathVariable Integer customerId) {
        return service.getCustomerAnalytics(customerId);
    }
}