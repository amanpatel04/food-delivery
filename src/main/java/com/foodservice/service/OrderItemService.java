package com.foodservice.service;

import com.foodservice.entity.dto.OrderItemDTO;

public interface OrderItemService {
    OrderItemDTO getOrderItemById(Integer orderItemId);
}
