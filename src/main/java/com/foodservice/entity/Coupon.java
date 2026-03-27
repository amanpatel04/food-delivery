package com.foodservice.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Coupons")
public class Coupon {
	
	@Id
	@Column(name="coupon_id")
	private Integer couponId;
	
	@Column(name="coupon_code")
	private String code;
	
	@Column(name="discount_amount")
	private BigDecimal discount;
	
	@Column(name="expiry_date")
	private LocalDate expiryDate;

}
