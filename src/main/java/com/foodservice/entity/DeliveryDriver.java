package com.foodservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeliveryDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    private String driverName;
    private String driverPhone;
    private String driverVehicle;
    
    public DeliveryDriver() {}
    
	public DeliveryDriver(Long driverId, String driverName, String driverPhone, String driverVehicle) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverPhone = driverPhone;
		this.driverVehicle = driverVehicle;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getDriverVehicle() {
		return driverVehicle;
	}

	public void setDriverVehicle(String driverVehicle) {
		this.driverVehicle = driverVehicle;
	}
}