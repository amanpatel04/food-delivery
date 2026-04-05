package com.foodservice.frontend.service;

import java.util.List;
import  com.foodservice.frontend.entity.dto.DeliveryDriverResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface DeliveryDriverService {

    List<DeliveryDriverResponseDTO> getAllDrivers();

    DeliveryDriverResponseDTO getDriverById(Integer id);

    List<DeliveryDriverResponseDTO> getDriverOrders(Integer id);

    List<DeliveryDriverResponseDTO> getDriverCustomers(Integer id);

    List<DeliveryDriverResponseDTO> getDriverRestaurants(Integer id);

    Integer getTotalOrders(Integer id);
}