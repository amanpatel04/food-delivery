package com.foodservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodservice.entity.Coupon;
import com.foodservice.entity.dto.OrderCouponDTO;

public interface CoupoonRepository extends JpaRepository<Coupon, Integer> {

	Coupon findByCode(String code); //basic crud

	@Query("""
			SELECT new com.foodservice.entity.dto.OrderCouponDTO(
			    c.code,
			    c.discount
			)
			FROM OrdersCoupons oc
			JOIN Coupon c ON oc.couponId = c.couponId
			WHERE oc.orderId = :orderId
			""")
	List<OrderCouponDTO> getCouponsByOrder(int orderId); //now for orderCoupons
	

}
