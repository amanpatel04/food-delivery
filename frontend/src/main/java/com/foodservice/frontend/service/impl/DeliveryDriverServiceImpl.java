package src.main.java.com.foodservice.frontend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodservice.frontend.service.DeliveryDriverService;
import com.foodservice.frontend.entity.dto.ApiResponseDTO;
import com.foodservice.frontend.entity.dto.DeliveryDriverResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    private final String BASE = "/drivers";

    @Override
    public List<DeliveryDriverResponseDTO> getAllDrivers() {
        ApiResponseDTO res = webClient.get()
                .uri(BASE)
                .retrieve()
                .bodyToMono(ApiResponseDTO.class)
                .block();

        List<?> rawList = (List<?>) res.getData();

        return rawList.stream()
                .map(obj -> objectMapper.convertValue(obj, DeliveryDriverResponseDTO.class))
                .toList();
    }

    @Override
    public DeliveryDriverResponseDTO getDriverById(Integer id) {
        ApiResponseDTO res = webClient.get()
                .uri(BASE + "/" + id)
                .retrieve()
                .bodyToMono(ApiResponseDTO.class)
                .block();

        return objectMapper.convertValue(res.getData(), DeliveryDriverResponseDTO.class);
    }

    @Override
    public List<DeliveryDriverResponseDTO> getDriverOrders(Integer id) {
        ApiResponseDTO res = webClient.get()
                .uri(BASE + "/" + id + "/orders")
                .retrieve()
                .bodyToMono(ApiResponseDTO.class)
                .block();

        List<?> rawList = (List<?>) res.getData();

        return rawList.stream()
                .map(obj -> objectMapper.convertValue(obj, DeliveryDriverResponseDTO.class))
                .toList();
    }

    @Override
    public List<DeliveryDriverResponseDTO> getDriverCustomers(Integer id) {
        ApiResponseDTO res = webClient.get()
                .uri(BASE + "/" + id + "/customers")
                .retrieve()
                .bodyToMono(ApiResponseDTO.class)
                .block();

        List<?> rawList = (List<?>) res.getData();

        return rawList.stream()
                .map(obj -> objectMapper.convertValue(obj, DeliveryDriverResponseDTO.class))
                .toList();
    }

    @Override
    public List<DeliveryDriverResponseDTO> getDriverRestaurants(Integer id) {
        ApiResponseDTO res = webClient.get()
                .uri(BASE + "/" + id + "/restaurants")
                .retrieve()
                .bodyToMono(ApiResponseDTO.class)
                .block();

        List<?> rawList = (List<?>) res.getData();

        return rawList.stream()
                .map(obj -> objectMapper.convertValue(obj, DeliveryDriverResponseDTO.class))
                .toList();
    }

    @Override
    public Integer getTotalOrders(Integer id) {
        ApiResponseDTO res = webClient.get()
                .uri(BASE + "/" + id + "/total-orders")
                .retrieve()
                .bodyToMono(ApiResponseDTO.class)
                .block();

        return (Integer) res.getData();
    }
}