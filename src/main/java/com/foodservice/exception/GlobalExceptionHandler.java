package com.foodservice.exception;
import com.foodservice.entity.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import lombok.extern.slf4j.Slf4j

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderInvalidRequestException.class)
    public ResponseEntity<ApiResponseDTO> handleOrderInvalidRequestException(OrderInvalidRequestException orderInvalidRequestException) {

        String message = HttpStatus.NOT_FOUND.toString()+", "+orderInvalidRequestException.getMessage();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDTO(HttpStatus.NOT_FOUND.value(), message, null));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponseDTO> handleTypeMismatch (MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {

        String message = HttpStatus.NOT_FOUND.toString()+", "+methodArgumentTypeMismatchException.getMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponseDTO(HttpStatus.BAD_REQUEST.value(), message, null));

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {

        String message = HttpStatus.NOT_FOUND.toString()+", "+ex.getMessage();
      
      
      log.error(
                "ResourceNotFoundException occurred while processing request. path={}, errorMessage={}, exceptionClass={}",
                webRequest.getDescription(false),
                ex.getMessage(),
                ex.getClass().getSimpleName(),
                ex
        );

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                LocalDateTime.now(),
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        log.debug(
                "Returning error response for ResourceNotFoundException. status={}, responseBody={}",
                HttpStatus.NOT_FOUND,
                errorResponse
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDTO(HttpStatus.NOT_FOUND.value(), message, null));

        

    }
}
