package com.foodservice.service;

import com.foodservice.entity.Order;
import com.foodservice.entity.dto.OrderCustomerDTO;
import com.foodservice.entity.dto.OrderDTO;
import com.foodservice.entity.dto.OrderWithItemDTO;

public interface OrderService {

    OrderWithItemDTO getOrderDetailsById(Integer orderId);

    OrderCustomerDTO getOrdersByCustomerId(Integer customerId);
}
