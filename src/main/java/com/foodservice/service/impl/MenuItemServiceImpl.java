package com.foodservice.service.impl;

import com.foodservice.entity.MenuItem;
import com.foodservice.entity.Restaurant;
import com.foodservice.entity.dto.MenuItemRequestDTO;
import com.foodservice.entity.dto.MenuItemResponseDTO;
import com.foodservice.config.CustomMapper;
import com.foodservice.repository.MenuItemRepository;
import com.foodservice.repository.RestaurantRepository;
import com.foodservice.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;
    private final CustomMapper customMapper;

    @Override
    public MenuItemResponseDTO addMenuItem(MenuItemRequestDTO requestDTO) {
        log.info("Adding new menu item '{}' to restaurant ID: {}", requestDTO.getItemName(), requestDTO.getRestaurantId());

        // Fetch the restaurant first to establish the relationship
        Restaurant restaurant = restaurantRepository.findById(requestDTO.getRestaurantId())
                .orElseThrow(() -> {
                    log.error("Restaurant ID {} not found", requestDTO.getRestaurantId());
                    return new RuntimeException("Restaurant not found");
                });

        MenuItem menuItem = customMapper.toMenuItemEntity(requestDTO);
        menuItem.setRestaurant(restaurant); // Set the foreign key relationship

        MenuItem savedItem = menuItemRepository.save(menuItem);
        log.info("Successfully added menu item with ID: {}", savedItem.getItemId());

        return customMapper.toMenuItemDto(savedItem);
    }

    @Override
    public Page<MenuItemResponseDTO> getMenuByRestaurantId(Integer restaurantId, Pageable pageable) {
        log.info("Fetching menu for restaurant ID: {} - Page: {}", restaurantId, pageable.getPageNumber());

        return menuItemRepository.findByRestaurant_RestaurantId(restaurantId, pageable)
                .map(customMapper::toMenuItemDto);
    }
}