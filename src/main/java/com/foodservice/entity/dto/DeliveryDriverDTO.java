package com.foodservice.entity.dto;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDriverDTO {
    private String driverName;
    private String driverPhone;
    private String driverVehicle;
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
