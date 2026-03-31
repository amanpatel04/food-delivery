package com.foodservice.controller;

import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.entity.dto.ApiResponseDTO;
import com.foodservice.service.DeliveryDriverService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
@RequiredArgsConstructor
public class DeliveryDriverController {

    private final DeliveryDriverService deliveryDriverservice;

    // ---------------- Get Driver by ID --------------
    @GetMapping(value = "/{driverId}", produces = "application/json")
    public ResponseEntity<ApiResponseDTO> getDriverById(@PathVariable Integer driverId) {
        DeliveryDriverResponseDTO driver = deliveryDriverservice.getDriverById(driverId);
        return ResponseEntity.ok(
                new ApiResponseDTO(200, "Driver fetched successfully", driver)
        );
    }

    // ---------- Get All Drivers ------------
    @GetMapping(produces = "application/json")
    public ResponseEntity<ApiResponseDTO> getAllDrivers() {
        List<DeliveryDriverResponseDTO> drivers = deliveryDriverservice.getAllDrivers();
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body(new ApiResponseDTO(200, "Drivers fetched successfully", drivers));
    }

    // --------------- Get Driver Deliveries ----------------
    @GetMapping("/{driverId}/deliveries")
    public ResponseEntity<ApiResponseDTO> getDriverDeliveries(@PathVariable Integer driverId) {
        List<DeliveryDriverResponseDTO> list = deliveryDriverservice.getDriverDeliveries(driverId);
        return ResponseEntity.ok(
            new ApiResponseDTO(200, "Driver deliveries fetched", list)
        );
    }
}