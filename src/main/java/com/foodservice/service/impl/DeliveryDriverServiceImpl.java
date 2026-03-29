package com.foodservice.service.impl;

import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.Order;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.exception.DriverNotFoundException;
import com.foodservice.repository.DeliveryDriverRepository;
import com.foodservice.repository.OrderRepository;
import com.foodservice.service.DeliveryDriverService;
import com.foodservice.config.CustomMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

	private final DeliveryDriverRepository deliveryDriverRepository;
	private final OrderRepository orderRepository;


    @Override
    public DeliveryDriverResponseDTO getDriverById(Long id) {
        DeliveryDriver driver = deliveryDriverRepository.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("Driver Not Found"));

        return CustomMapper.deliveryDriverToDTO(driver);
    }

    @Override
    public List<DeliveryDriverResponseDTO> getAllDrivers() {
        return deliveryDriverRepository.findAll()
                .stream()
                .map(CustomMapper::deliveryDriverToDTO)
                .toList();
    }

    @Override
    public List<DeliveryDriverResponseDTO> getDriverDeliveries(Long driverId) {

        List<Order> orders = orderRepository.findOrdersByDriverId(driverId);

        return orders.stream()
                .map(order -> {
                    DeliveryDriverResponseDTO dto = new DeliveryDriverResponseDTO();
                    dto.setOrderId(order.getOrderId());
                    dto.setCustomerName(order.getCustomer().getCustomerName());
                    dto.setResturentName(order.getRestaurant().getRestaurantName());
                    dto.setOrderStatus(order.getOrderStatus());
                    return dto;
                })
                .toList();
    }
    
//	@Override
//	public List<DeliveryDriver> getDriversWithOrders() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}