package com.foodservice.service.impl;

import com.foodservice.config.CustomMapper;
import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.Order;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.exception.DriverNotFoundException;
import com.foodservice.repository.DeliveryDriverRepository;
import com.foodservice.repository.OrderRepository;
import com.foodservice.service.DeliveryDriverService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

    private final DeliveryDriverRepository deliveryDriverRepository;
    private final OrderRepository orderRepository;

    //  Get Driver by ID
    @Override
    public DeliveryDriverResponseDTO getDriverById(Integer driverId) {

        DeliveryDriver driver = deliveryDriverRepository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException("Driver not found"));

        return CustomMapper.deliveryDriverToDTO(driver);
    }

    //  Get All Drivers
    @Override
    public List<DeliveryDriverResponseDTO> getAllDrivers() {

        return deliveryDriverRepository.findAll()
                .stream()
                .map(CustomMapper::deliveryDriverToDTO)
                .toList();
    }

    // Get Driver Deliveries
    @Override
    public List<DeliveryDriverResponseDTO> getDriverDeliveries(Integer driverId) {

        List<Order> orders = orderRepository.findByDeliveryDriver_DriverId(driverId);

        return orders.stream().map(order -> {
            DeliveryDriverResponseDTO dto = new DeliveryDriverResponseDTO();

            dto.setDriverId(order.getDeliveryDriver().getDriverId());
            dto.setDriverName(order.getDeliveryDriver().getDriverName());
            dto.setDriverPhone(order.getDeliveryDriver().getDriverPhone());
            dto.setDriverVehicle(order.getDeliveryDriver().getDriverVehicle());

            dto.setOrderId(order.getOrderId());
            dto.setCustomerName(order.getCustomer().getCustomerName());
            dto.setResturentName(order.getRestaurant().getRestaurantName());
            dto.setOrderStatus(order.getOrderStatus());

            return dto;
        }).toList();
    }
}