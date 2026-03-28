package com.foodservice.entity.dto;

import com.foodservice.entity.Customer;
import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private CustomerDTO customer;
    private RestaurantResponseDTO restaurant;
    private DeliveryDriverDTO deliveryDriver;
    private LocalDateTime orderDate;
    private String orderStatus;
    private List<OrderItemDetailDTO> orderItems;
}
