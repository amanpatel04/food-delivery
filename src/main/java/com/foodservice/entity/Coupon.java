package com.foodservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="coupons")
public class Coupon {
	
	@Id
	@Column(name="coupon_id")
	private int id;
	
	@Column(name="coupon_code")
	private String code;
	
	@Column(name="discount_amount")
	private double discount;
	
	@Column(name="expiry_date")
	private LocalDate expiryDate;
}
