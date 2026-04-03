package com.foodservice.frontend.service;

import com.foodservice.frontend.entity.dto.RestaurantRatingsDTO;

import java.util.Map;

public interface RestaurantService {
    RestaurantRatingsDTO getRestaurantRatings(Integer id, Map<String, String> params, String token);
}
