package com.foodservice.entity.dto;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDriverResponseDTO {
    private Integer driverId;
    private String driverName;
    private String driverPhone;
    private String driverVehicle;

    private Integer orderId;
    private String customerName;
    private String resturentName;
    private String orderStatus;
}
