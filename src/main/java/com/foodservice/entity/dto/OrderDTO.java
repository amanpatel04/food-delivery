package com.foodservice.entity.dto;

import com.foodservice.entity.Customer;
import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Customer customer;
    private Restaurant restaurant;
    private DeliveryDriver deliveryDriver;
    private LocalDateTime orderDate;
    private String orderStatus;
}
