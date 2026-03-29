package com.foodservice.repository;

import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.foodservice.entity.DeliveryDriver;

@Repository
public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, Long> {
	@Query("SELECT DISTINCT d FROM DeliveryDriver d JOIN FETCH d.orders")
    List<DeliveryDriver> findDriversWithOrders();
	
	@Query("SELECT o FROM Order o WHERE o.deliveryDriver.driverId = :driverId")
	List<Order> findOrdersByDriverId(Long driverId);

	Optional<DeliveryDriver> findById(Integer id);

}