package com.foodservice.controller;

import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.service.DeliveryDriverService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DeliveryDriverController {

    private final DeliveryDriverService service;

    // Get Driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDriverResponseDTO> getDriverById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getDriverById(id));
    }

    // Get All Drivers
    @GetMapping
    public ResponseEntity<List<DeliveryDriverResponseDTO>> getAllDrivers() {
        return ResponseEntity.ok(service.getAllDrivers());
    }
}