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
	
	
    private final DeliveryDriverService deliveryDriverservice = null;

    // ------- Get Driver by ID ----------
    @GetMapping("/{driverId}")
    public ResponseEntity<ResponseDTO> getDriverById(@PathVariable Long driverId) {
        
        DeliveryDriverResponseDTO dto = deliveryDriverservice.getDriverById(driverId);

        return ResponseEntity.status(200).body(new ResponseDTO(200, "Driver fetched successfully", dto));
    }

    // ----- Get All Drivers ----------
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllDrivers() {
        
        List<DeliveryDriverResponseDTO> drivers = deliveryDriverservice.getAllDrivers();

        return ResponseEntity.status(200).body(new ResponseDTO(200, "All drivers fetched successfully", drivers));
    }
    //------- Get Driver Deliveries ----------
    @GetMapping("/{driverId}/deliveries")
    public ResponseEntity<ResponseDTO> getDriverDeliveries(@PathVariable Long driverId) {
        
        List<DeliveryDriverResponseDTO> deliveries = deliveryDriverservice.getDriverDeliveries(driverId);

        return ResponseEntity.status(200).body(new ResponseDTO(200, "Driver deliveries fetched successfully", deliveries));
    }
}