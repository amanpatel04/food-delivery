package com.foodservice.frontend.service.impl;

import com.foodservice.frontend.entity.dto.ApiResponseDTO;
import com.foodservice.frontend.entity.dto.OrderCustomerDTO;
import com.foodservice.frontend.service.OrderService;
import com.foodservice.frontend.util.ApiGetRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final WebClient webClient;
    @Override
    public OrderCustomerDTO getOrdersByCustomerId(Integer customerId, Integer page, Integer size, String token) {

        ApiGetRequest<OrderCustomerDTO> apiGetRequest = new ApiGetRequest<>(webClient);
        
        return apiGetRequest.get("/orders/customer/" + customerId, 
                Map.of("page", page.toString(), "size", size.toString()), 
                token, 
                new ParameterizedTypeReference<ApiResponseDTO<OrderCustomerDTO>>() {});
    }
}
