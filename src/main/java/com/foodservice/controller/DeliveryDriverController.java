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
	
	
    private DeliveryDriverService deliveryDriverservice ;

    // ------- Get Driver by ID ----------
    @GetMapping("/{driverId}")
    public ResponseEntity<DeliveryDriverResponseDTO> getDriverById(@PathVariable Long driverId) {
        return ResponseEntity.ok(deliveryDriverservice.getDriverById(driverId));
    }

    // ----- Get All Drivers ----------
    @GetMapping
    public ResponseEntity<List<DeliveryDriverResponseDTO>> getAllDrivers() {
        return ResponseEntity.ok(deliveryDriverservice.getAllDrivers());
    }

    //------- Get Driver Deliveries ----------
    @GetMapping("/{driverId}/deliveries")
    public ResponseEntity<List<DeliveryDriverResponseDTO>> getDriverDeliveries(@PathVariable Long driverId) {
        return ResponseEntity.ok(deliveryDriverservice.getDriverDeliveries(driverId));
    }
}