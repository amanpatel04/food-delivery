package com.foodservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrderInvalidRequestException extends RuntimeException {
    public OrderInvalidRequestException(String message) {
        super(message);
    }
}
