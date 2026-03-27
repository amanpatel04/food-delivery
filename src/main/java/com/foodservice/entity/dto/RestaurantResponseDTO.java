package com.foodservice.entity.dto;

import lombok.Data;

@Data
public class RestaurantResponseDTO {
    private Integer restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;
}