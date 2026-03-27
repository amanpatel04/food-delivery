package com.foodservice.service.impl;

import com.foodservice.entity.Restaurant;
import com.foodservice.entity.dto.RestaurantRequestDTO;
import com.foodservice.entity.dto.RestaurantResponseDTO;
import com.foodservice.config.CustomMapper;
import com.foodservice.repository.RestaurantRepository;
import com.foodservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

//    @Override
//    public RestaurantResponseDTO createRestaurant(RestaurantRequestDTO requestDTO) {
//        log.info("Creating new restaurant: {}", requestDTO.getRestaurantName());
//
//        // Basic check to prevent duplicate phone numbers
//        if (restaurantRepository.existsByRestaurantPhone(requestDTO.getRestaurantPhone())) {
//            log.error("Restaurant creation failed. Phone number already exists: {}", requestDTO.getRestaurantPhone());
//            throw new RuntimeException("Phone number already in use");
//        }
//
//        Restaurant restaurant = customMapper.toRestaurantEntity(requestDTO);
//        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
//
//        log.info("Successfully created restaurant with ID: {}", savedRestaurant.getRestaurantId());
//        return customMapper.toRestaurantDto(savedRestaurant);
//    }

    @Override
    public Page<RestaurantResponseDTO> getAllRestaurants(Pageable pageable) {
        log.info("Fetching restaurants with pagination - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());

        // The repository returns a Page<Restaurant>, and we map each one to a DTO
        return restaurantRepository.findAll(pageable)
                .map(CustomMapper::toRestaurantDto);
    }
}