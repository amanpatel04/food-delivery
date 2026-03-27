package com.foodservice.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RestaurantRequestDTO {
    @NotBlank(message = "Restaurant name cannot be empty")
    private String restaurantName;

    @NotBlank(message = "Restaurant address cannot be empty")
    private String restaurantAddress;

    @NotBlank(message = "Phone number is required")
    private String restaurantPhone;
}
