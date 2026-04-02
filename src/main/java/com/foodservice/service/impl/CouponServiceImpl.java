package com.foodservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodservice.entity.dto.OrderCouponDTO;
import com.foodservice.exception.ResourceNotFoundException;
import com.foodservice.repository.CouponRepository;
import com.foodservice.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public List<OrderCouponDTO> getCouponsByOrder(int orderId) {

        List<OrderCouponDTO> coupons = couponRepository.getCouponsByOrder(orderId);

        // Optional safety check
        if (coupons.isEmpty()) {
            throw new ResourceNotFoundException("No coupons found for this order");
        }

        return coupons;
    }
}