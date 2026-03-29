package com.foodservice.controller;

import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.entity.dto.ResponseDTO;
import com.foodservice.service.DeliveryDriverService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DeliveryDriverController {

    private final DeliveryDriverService deliveryDriverService;

    // ------- Get Driver by ID ----------
    @GetMapping("/{driverId}")
    public ResponseEntity<ResponseDTO> getDriverById(@PathVariable Integer driverId) {

        DeliveryDriverResponseDTO dto = deliveryDriverService.getDriverById(driverId);

        return ResponseEntity.ok(new ResponseDTO(200, "Driver fetched successfully", dto));
    }

    // ----- Get All Drivers ----------
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllDrivers() {

        List<DeliveryDriverResponseDTO> drivers = deliveryDriverService.getAllDrivers();

        return ResponseEntity.ok(new ResponseDTO(200, "All drivers fetched successfully", drivers));
    }

    //------- Get Driver Deliveries ----------
    @GetMapping("/{driverId}/deliveries")
    public ResponseEntity<ResponseDTO> getDriverDeliveries(@PathVariable Integer driverId) {

        List<DeliveryDriverResponseDTO> deliveries = deliveryDriverService.getDriverDeliveries(driverId);

        return ResponseEntity.ok(new ResponseDTO(200, "Driver deliveries fetched successfully", deliveries));
    }
}