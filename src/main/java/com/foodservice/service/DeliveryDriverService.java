package com.foodservice.service;

import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DeliveryDriverService {

	DeliveryDriverResponseDTO getDriverById(Long id);
	List<DeliveryDriverResponseDTO> getAllDrivers();
//    List<DeliveryDriver> getDriversWithOrders();
    List<DeliveryDriverResponseDTO> getDriverDeliveries(Long driverId);
    
}