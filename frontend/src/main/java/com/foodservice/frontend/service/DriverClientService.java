package com.foodservice.frontend.service;

import java.util.Collections;

import com.foodservice.frontend.entity.dto.ApiResponseDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.foodservice.frontend.entity.dto.DriverResponseDTO;
import com.foodservice.frontend.util.ApiGetRequest;

@Service
public class DriverClientService {

    private final ApiGetRequest apiGetRequest;

    public DriverClientService(ApiGetRequest apiGetRequest) {
        this.apiGetRequest = apiGetRequest;
    }

    // Fetch driver details for a given order
    @SuppressWarnings("unchecked")
    public DriverResponseDTO getDriverByOrderId(int orderId, String token) {

        return (DriverResponseDTO) apiGetRequest.get(
                "/orders/" + orderId + "/driver",
                Collections.emptyMap(),
                token,
                new ParameterizedTypeReference<ApiResponseDTO<DriverResponseDTO>>() {}
        );
    }
}