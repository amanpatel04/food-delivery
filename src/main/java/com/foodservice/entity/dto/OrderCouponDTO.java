package com.foodservice.entity.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCouponDTO {
	private String couponCode;
	private BigDecimal discount;
}
