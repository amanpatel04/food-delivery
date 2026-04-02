package com.foodservice.frontend.service.impl;

import com.foodservice.frontend.entity.dto.*;
import com.foodservice.frontend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final WebClient webClient;

    @Override
    public List<CustomerDTO> getAllCustomers(int page, int size) {
        ApiResponseDTO<List<CustomerDTO>> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/customers")
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<List<CustomerDTO>>>() {})
                .block();

        return response.getData();
    }

    @Override
    public CustomerDTO getCustomerById(Integer id) {
        ApiResponseDTO<CustomerDTO> response = webClient.get()
                .uri("/customers/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<CustomerDTO>>() {})
                .block();

        return response.getData();
    }

    @Override
    public List<DeliveryAddressDTO> getAddresses(Integer id) {
        ApiResponseDTO<List<DeliveryAddressDTO>> response = webClient.get()
                .uri("/customers/{id}/addresses", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<List<DeliveryAddressDTO>>>() {})
                .block();

        return response.getData();
    }

    @Override
    public List<OrderItemDetailDTO> getOrders(Integer id) {
        ApiResponseDTO<List<OrderItemDetailDTO>> response = webClient.get()
                .uri("/customers/{id}/orders", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<List<OrderItemDetailDTO>>>() {})
                .block();

        return response.getData();
    }

    @Override
    public Integer getAddressCount(Integer id) {
        ApiResponseDTO<Integer> response = webClient.get()
                .uri("/customers/{id}/address-count", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<Integer>>() {})
                .block();

        return response.getData();
    }

    @Override
    public CustomerAnalyticsDTO getAnalytics(Integer id) {
        ApiResponseDTO<CustomerAnalyticsDTO> response = webClient.get()
                .uri("/customers/{id}/analytics", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<CustomerAnalyticsDTO>>() {})
                .block();

        return response.getData();
    }
}