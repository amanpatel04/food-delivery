package com.foodservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
	private Integer statusCode;
	private String message;
	private Object data;
	public ResponseDTO() {}
	public ResponseDTO(int status, String message, Object data) {
	    this.statusCode = status;
	    this.message = message;
	    this.data = data;
	}
	
}
