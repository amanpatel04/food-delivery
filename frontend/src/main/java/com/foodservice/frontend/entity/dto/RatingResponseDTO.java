package com.foodservice.frontend.entity.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RatingResponseDTO {
    private Integer rating;
    private String review;
    private String customerName;
    private String customerPhone;
    private LocalDateTime orderDate;
}