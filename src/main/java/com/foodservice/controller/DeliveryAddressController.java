package com.foodservice.controller;

import com.foodservice.entity.dto.ApiResponseDTO;
import com.foodservice.entity.dto.DeliveryAddressDTO;
import com.foodservice.service.DeliveryAddressService;
import com.foodservice.constants.DeliveryAddressConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery-address")
@RequiredArgsConstructor
@Slf4j
public class DeliveryAddressController {

    private final DeliveryAddressService deliveryAddressService;

    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<ApiResponseDTO> getAddressById(@PathVariable Integer addressId) {

        log.info("Received request to fetch delivery address details. addressId={}", addressId);

        DeliveryAddressDTO address = deliveryAddressService.getAddressById(addressId);

        log.debug("Successfully fetched delivery address details. addressId={}, addressData={}", addressId, address);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponseDTO(
                        DeliveryAddressConstant.STATUS_200,
                        DeliveryAddressConstant.MESSAGE_ADDRESS_FETCHED,
                        address
                ));
    }

    @GetMapping("/addresses/city")
    public ResponseEntity<ApiResponseDTO> getAddressesByCity(@RequestParam String city) {

        log.info("Received request to fetch delivery addresses by city. city={}", city);

        List<DeliveryAddressDTO> addressesByCity = deliveryAddressService.getAddressesByCity(city);

        log.debug("Successfully fetched delivery addresses by city. city={}, resultCount={}", city, addressesByCity.size());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponseDTO(
                        DeliveryAddressConstant.STATUS_200,
                        DeliveryAddressConstant.MESSAGE_ADDRESSES_FETCHED_BY_CITY,
                        addressesByCity
                ));
    }
}