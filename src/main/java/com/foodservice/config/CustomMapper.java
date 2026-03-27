package com.foodservice.config;

import com.foodservice.entity.*;
import com.foodservice.entity.Customer;
import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.MenuItem;
import com.foodservice.entity.Order;
import com.foodservice.entity.Restaurant;
import com.foodservice.entity.dto.*;
import org.springframework.stereotype.Component;

public class CustomMapper {

    public static CustomerDTO customerToCustomerDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerName(customer.getCustomerName());
        dto.setCustomerEmail(customer.getCustomerEmail());
        dto.setCustomerPhone(customer.getCustomerPhone());
        return dto;
    }

    public static Customer customerDTOToCustomer(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());
        customer.setCustomerEmail(dto.getCustomerEmail());
        customer.setCustomerPhone(dto.getCustomerPhone());
        return customer;
    }

    // Restaurant Mappings
    public static Restaurant toRestaurantEntity(RestaurantRequestDTO dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(dto.getRestaurantName());
        restaurant.setRestaurantAddress(dto.getRestaurantAddress());
        restaurant.setRestaurantPhone(dto.getRestaurantPhone());
        return restaurant;
    }

    public static RestaurantResponseDTO toRestaurantDto(Restaurant entity) {
        RestaurantResponseDTO dto = new RestaurantResponseDTO();
        // dto.setRestaurantId(entity.getRestaurantId());
        dto.setRestaurantName(entity.getRestaurantName());
        dto.setRestaurantAddress(entity.getRestaurantAddress());
        dto.setRestaurantPhone(entity.getRestaurantPhone());
        return dto;
    }

    // MenuItem Mappings
    public static MenuItem toMenuItemEntity(MenuItemRequestDTO dto) {
        MenuItem menuItem = new MenuItem();
        menuItem.setItemName(dto.getItemName());
        menuItem.setItemDescription(dto.getItemDescription());
        menuItem.setItemPrice(dto.getItemPrice());
        return menuItem;
    }

    public static MenuItemResponseDTO toMenuItemDto(MenuItem entity) {
        MenuItemResponseDTO dto = new MenuItemResponseDTO();
        dto.setItemId(entity.getItemId());
        dto.setItemName(entity.getItemName());
        dto.setItemDescription(entity.getItemDescription());
        dto.setItemPrice(entity.getItemPrice());
        if (entity.getRestaurant() != null) {
            dto.setRestaurantId(entity.getRestaurant().getRestaurantId());
        }
        return dto;
    }

    public static OrderDTO orderToOrderDTO(Order order, OrderDTO orderDTO) {
        DeliveryDriverDTO deliveryDriverDTO = new DeliveryDriverDTO();
        deliveryDriverDTO.setDriverName(order.getDeliveryDriver().getDriverName());
        deliveryDriverDTO.setDriverPhone(order.getDeliveryDriver().getDriverPhone());
        deliveryDriverDTO.setDriverVehicle(order.getDeliveryDriver().getDriverVehicle());

        orderDTO.setCustomer(customerToCustomerDTO(order.getCustomer()));
        orderDTO.setRestaurant(toRestaurantDto(order.getRestaurant()));
        orderDTO.setDeliveryDriver(deliveryDriverDTO);
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setOrderDate(order.getOrderDate());
        return orderDTO;
    }



    public static DeliveryAddressDTO deliveryAddressToDTO(DeliveryAddress address) {
        DeliveryAddressDTO dto = new DeliveryAddressDTO();

        dto.setId(address.getAddressId());

        if (address.getCustomer() != null) {
            dto.setCustomerId(address.getCustomer().getCustomerId());
        }

        dto.setAddressLine1(address.getAddressLine1());
        dto.setAddressLine2(address.getAddressLine2());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setPostalCode(address.getPostalCode());

        return dto;
    }
    
    
    public static DeliveryAddress dtoToDeliveryAddress(DeliveryAddressDTO dto) {
        DeliveryAddress address = new DeliveryAddress();

        address.setAddressId(dto.getId());

        if (dto.getCustomerId() != null) {
            Customer customer = new Customer();
            customer.setCustomerId(dto.getCustomerId());
            address.setCustomer(customer);
        }

        address.setAddressLine1(dto.getAddressLine1());
        address.setAddressLine2(dto.getAddressLine2());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPostalCode(dto.getPostalCode());

        return address;
    }
    
    public static DeliveryDriverResponseDTO deliveryDriverToDTO(DeliveryDriver driver) {
        DeliveryDriverResponseDTO dto = new DeliveryDriverResponseDTO();

        dto.setDriverId(driver.getDriverId());
        dto.setDriverName(driver.getDriverName());
        dto.setDriverPhone(driver.getDriverPhone());
        dto.setDriverVehicle(driver.getDriverVehicle());

        return dto;
    }
    
}
