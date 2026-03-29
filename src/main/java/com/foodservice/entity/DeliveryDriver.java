package com.foodservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@Table(name = "DeliveryDrivers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDriver {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "driver_name", nullable = false)
    private String driverName;

    @Column(name = "driver_phone", nullable = false)
    private String driverPhone;

    @Column(name = "driver_vehicle")
    private String driverVehicle;
}