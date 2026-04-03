package com.foodservice.frontend.entity.dto;

import lombok.Data;
import java.util.List;

@Data
public class RestaurantRatingsDTO {
    private List<RatingResponseDTO> content;
    private Page page;
}