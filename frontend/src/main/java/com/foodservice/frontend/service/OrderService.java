package com.foodservice.frontend.service;

import com.foodservice.frontend.entity.dto.OrderCustomerDTO;

public interface OrderService {
    OrderCustomerDTO getOrdersByCustomerId(Integer customerId, Integer page, Integer size, String status, String sort);
}
