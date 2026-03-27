package com.foodservice.service;

import com.foodservice.entity.dto.RestaurantRequestDTO;
import com.foodservice.entity.dto.RestaurantResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantService {
//    RestaurantResponseDTO createRestaurant(RestaurantRequestDTO requestDTO);
    Page<RestaurantResponseDTO> getAllRestaurants(Pageable pageable);
}