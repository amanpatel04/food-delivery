package com.foodservice.entity.dto;

import lombok.Data;

@Data
public class DeliveryAddressDTO {
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String postalCode;
}