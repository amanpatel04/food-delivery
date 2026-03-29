package com.foodservice.service.impl;

import com.foodservice.config.CustomMapper;
import com.foodservice.entity.OrderItem;
import com.foodservice.entity.dto.OrderDTO;
import com.foodservice.entity.dto.OrderItemDTO;
import com.foodservice.exception.ResourceNotFoundException;
import com.foodservice.repository.OrderItemRepository;
import com.foodservice.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItemDTO getOrderItemById(Integer orderItemId) {

        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Order item not found with id: %s", orderItemId)));

        return CustomMapper.orderItemToOrderItemDTO(orderItem, new OrderItemDTO());
    }
}
