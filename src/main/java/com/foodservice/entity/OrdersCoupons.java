package com.foodservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "OrdersCoupons")
@IdClass(OrdersCouponsId.class)
public class OrdersCoupons {

	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;

	@Id
	@Column(name = "order_id")
	private int orderId;
	
	@Id
	@Column(name = "coupon_id")
	private int couponId;
}