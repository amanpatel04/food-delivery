package com.foodservice.frontend.service;

import java.util.List;

import com.foodservice.frontend.entity.dto.ApiResponseDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.foodservice.frontend.entity.dto.OrderCouponDTO;

@Service
public class CouponClientService {

    private final WebClient webClient;

    public CouponClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<OrderCouponDTO> getCouponsByOrder(int orderId, String token) {

        System.out.println("Sending token to backend: " + token);

        ApiResponseDTO<List<OrderCouponDTO>> response =
                webClient.get()
                        .uri("/coupons/order/{orderId}", orderId)
                        .header("Cookie", "token=" + token)   // 🔥 CRITICAL LINE
                        .retrieve()
                        .bodyToMono(new ParameterizedTypeReference<ApiResponseDTO<List<OrderCouponDTO>>>() {})
                        .block();

        System.out.println("FULL RESPONSE: " + response);

        return response.getData();
    }

}