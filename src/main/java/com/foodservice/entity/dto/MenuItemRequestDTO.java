package com.foodservice.entity.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuItemRequestDTO {
    @NotBlank(message = "Item name is required")
    private String itemName;

    private String itemDescription;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    private BigDecimal itemPrice;

    @NotNull(message = "Restaurant ID is required")
    private Integer restaurantId;
}
