package com.foodservice.frontend.entity.dto;

import lombok.Data;

@Data
public class DeliveryDriverResponseDTO {

    private String driverName;
    private String driverPhone;
    private String driverVehicle;

    private Integer customerId;
    private String customerName;

    private Integer restaurantId;
    private String restaurantName;

    private String orderStatus;
}