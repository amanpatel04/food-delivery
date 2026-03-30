package com.foodservice.entity.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class MenuItemResponseDTO {
    private String itemName;
    private String itemDescription;
    private BigDecimal itemPrice;
}