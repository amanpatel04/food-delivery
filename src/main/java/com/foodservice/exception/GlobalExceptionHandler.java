package com.foodservice.exception;

import com.foodservice.entity.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderInvalidRequestException.class)
    public ResponseEntity<ErrorResponseDTO> handleOrderInvalidRequestException(OrderInvalidRequestException ex, WebRequest webRequest) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                LocalDateTime.now(),
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
