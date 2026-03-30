package com.foodservice.service;

import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import java.util.List;

public interface DeliveryDriverService {

    // Get single driver
    DeliveryDriverResponseDTO getDriverById(Integer driverId);

    // Get all drivers
    List<DeliveryDriverResponseDTO> getAllDrivers();

    // Get driver deliveries (orders handled by driver)
    List<DeliveryDriverResponseDTO> getDriverDeliveries(Integer driverId);
}