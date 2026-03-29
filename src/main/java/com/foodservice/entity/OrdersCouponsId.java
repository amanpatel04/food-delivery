package com.foodservice.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrdersCouponsId implements Serializable {

	private int orderId;
	private int couponId;
}