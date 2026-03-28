package com.foodservice.controller;

import com.foodservice.entity.dto.DeliveryAddressDTO;
import com.foodservice.service.DeliveryAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DeliveryAddressController {

    private final DeliveryAddressService service;

    @GetMapping("/customers/{customerId}/addresses")
    public List<DeliveryAddressDTO> getAddressesByCustomerId(@PathVariable Integer customerId) {
        return service.getAddressesByCustomerId(customerId);
    }

    @GetMapping("/addresses/{addressId}")
    public DeliveryAddressDTO getAddressById(@PathVariable Integer addressId) {
        return service.getAddressById(addressId);
    }

    @GetMapping("/customers/{customerId}/addresses/count")
    public int getAddressCount(@PathVariable Integer customerId) {
        return service.getAddressCount(customerId);
    }

    @GetMapping("/addresses/city")
    public List<DeliveryAddressDTO> getAddressesByCity(@RequestParam String city) {
        return service.getAddressesByCity(city);
    }

    @GetMapping("/customers/{customerId}/addresses/default")
    public DeliveryAddressDTO getDefaultAddress(@PathVariable Integer customerId) {
        return service.getDefaultAddress(customerId);
    }
}