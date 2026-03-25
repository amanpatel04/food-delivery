package com.foodservice.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodservice.entity.DeliveryDriver;

public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, Long> {
}