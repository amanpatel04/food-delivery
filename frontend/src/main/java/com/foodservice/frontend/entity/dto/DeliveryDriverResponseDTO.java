package com.foodservice.frontend.entity.dto;

import lombok.Data;

@Data
public class DeliveryDriverResponseDTO {
    private Integer driverId;
    private String driverName;
    private String driverPhone;

    private Integer customerId;
    private String customerName;

    private Integer orderId;

    private Integer restaurantId;
    private String restaurantName;
    private String driverVehicle;

    private String orderStatus;
}