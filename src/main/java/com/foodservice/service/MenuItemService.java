package com.foodservice.service;

import com.foodservice.entity.dto.MenuItemRequestDTO;
import com.foodservice.entity.dto.MenuItemResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuItemService {
//    MenuItemResponseDTO addMenuItem(MenuItemRequestDTO requestDTO);
    Page<MenuItemResponseDTO> getMenuByRestaurantId(Integer restaurantId, Pageable pageable);
}