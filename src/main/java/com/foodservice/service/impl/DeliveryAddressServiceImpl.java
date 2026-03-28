package com.foodservice.service.impl;

import com.foodservice.config.CustomMapper;
import com.foodservice.entity.DeliveryAddress;
import com.foodservice.entity.dto.DeliveryAddressDTO;
import com.foodservice.exception.ResourceNotFoundException;
import com.foodservice.repository.DeliveryAddressRepository;
import com.foodservice.service.DeliveryAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private final DeliveryAddressRepository repository;

    @Override
    public List<DeliveryAddressDTO> getAddressesByCustomerId(Integer customerId) {

        List<DeliveryAddressDTO> addresses = repository.findByCustomerCustomerId(customerId)
                .stream()
                .map(CustomMapper::deliveryAddressToDTO)
                .toList();

        if (addresses.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No addresses found for customer id: " + customerId
            );
        }

        return addresses;
    }

    @Override
    public DeliveryAddressDTO getAddressById(Integer addressId) {

        DeliveryAddress address = repository.findById(addressId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Address not found with id: " + addressId)
                );

        return CustomMapper.deliveryAddressToDTO(address);
    }

    @Override
    public Integer getAddressCount(Integer customerId) {
        return repository.countByCustomerCustomerId(customerId);
    }

    @Override
    public List<DeliveryAddressDTO> getAddressesByCity(String city) {

        List<DeliveryAddressDTO> addresses = repository.findByCityIgnoreCase(city)
                .stream()
                .map(CustomMapper::deliveryAddressToDTO)
                .toList();

        if (addresses.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No addresses found in city: " + city
            );
        }

        return addresses;
    }

    @Override
    public DeliveryAddressDTO getDefaultAddress(Integer customerId) {

        DeliveryAddress address = repository.findFirstByCustomerCustomerId(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Default address not found for customer id: " + customerId
                        )
                );

        return CustomMapper.deliveryAddressToDTO(address);
    }
}