package com.foodservice.frontend.service.impl;

import com.foodservice.frontend.entity.dto.ApiResponseDTO;
import com.foodservice.frontend.entity.dto.DeliveryAddressDTO;
import com.foodservice.frontend.service.DeliveryAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private final WebClient webClient;

    @Override
    public DeliveryAddressDTO getAddressById(Integer addressId) {

        ApiResponseDTO<DeliveryAddressDTO> response = webClient.get()
                .uri("/delivery-address/addresses/{addressId}", addressId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<DeliveryAddressDTO>>() {})
                .block();

        return response.getData();
    }

    @Override
    public List<DeliveryAddressDTO> getAddressesByCity(String city) {

        ApiResponseDTO<List<DeliveryAddressDTO>> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/delivery-address/addresses/city")
                        .queryParam("city", city)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<List<DeliveryAddressDTO>>>() {})
                .block();

        return response.getData();
    }
}