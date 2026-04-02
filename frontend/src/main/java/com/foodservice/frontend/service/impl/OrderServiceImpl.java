package com.foodservice.frontend.service.impl;

import com.foodservice.frontend.entity.dto.ApiResponseDTO;
import com.foodservice.frontend.entity.dto.OrderCustomerDTO;
import com.foodservice.frontend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final WebClient webClient;

    @Override
    public OrderCustomerDTO getOrdersByCustomerId(Integer customerId, Integer page, Integer size, String status, String sort) {
        ApiResponseDTO<OrderCustomerDTO> apiResponse = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/orders/customer/"+customerId)
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<OrderCustomerDTO>>() {})
                .block();


        if (apiResponse != null && apiResponse.getData() != null) {
            OrderCustomerDTO orderCustomerDTO = apiResponse.getData();
            return orderCustomerDTO;
        }

        return null;
    }
}
