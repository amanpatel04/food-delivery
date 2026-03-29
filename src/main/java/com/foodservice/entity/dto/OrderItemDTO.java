package com.foodservice.entity.dto;

import com.foodservice.entity.MenuItem;
import com.foodservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private OrderDTO orderDTO;
    private MenuItemResponseDTO menuItemResponseDTO;
    private Integer quantity;
}
