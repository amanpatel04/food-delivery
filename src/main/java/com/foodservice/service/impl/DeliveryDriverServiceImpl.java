package com.foodservice.service.impl;

import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.exception.DriverNotFoundException;
import com.foodservice.repository.DeliveryDriverRepository;
import com.foodservice.service.DeliveryDriverService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

    private final DeliveryDriverRepository deliveryDriverRepository;

    // ✅ Get Driver by ID
    @Override
    public DeliveryDriverResponseDTO getDriverById(Integer driverId) {

        DeliveryDriver driver = deliveryDriverRepository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException("Driver not found"));

        return mapToDTO(driver);
    }

    // ✅ Get All Drivers
    @Override
    public List<DeliveryDriverResponseDTO> getAllDrivers() {

        return deliveryDriverRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ❌ TEMPORARILY DISABLE (to avoid breaking project)
    @Override
    public List<DeliveryDriverResponseDTO> getDriverDeliveries(Integer driverId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // Manual Mapper (SAFE)
    private DeliveryDriverResponseDTO mapToDTO(DeliveryDriver driver) {
        DeliveryDriverResponseDTO dto = new DeliveryDriverResponseDTO();
        dto.setDriverId(driver.getDriverId());
        dto.setDriverName(driver.getDriverName());
        dto.setDriverPhone(driver.getDriverPhone());
        dto.setDriverVehicle(driver.getDriverVehicle());
        return dto;
    }
}