package com.foodservice.service;

import java.util.List;

import com.foodservice.entity.dto.OrderCouponDTO;

public interface CouponService {
	
	List<OrderCouponDTO> getCouponsByOrder(int orderId);
}
