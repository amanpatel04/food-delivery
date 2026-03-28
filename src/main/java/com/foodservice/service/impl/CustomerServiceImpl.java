package com.foodservice.service.impl;
import com.foodservice.entity.Customer;
import com.foodservice.entity.DeliveryAddress;
import com.foodservice.entity.dto.CustomerDTO;
import com.foodservice.config.CustomMapper;
import com.foodservice.entity.dto.OrderItemDetailDTO;
import com.foodservice.exception.ResourceNotFoundException;
import com.foodservice.repository.CustomerRepository;
import com.foodservice.repository.DeliveryAddressRepository;
import com.foodservice.repository.OrderRepository;
import com.foodservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final DeliveryAddressRepository addressRepository;
    private final OrderRepository orderRepository;

    @Override
    public CustomerDTO getCustomerById(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id: " + customerId)
                );

        return CustomMapper.customerToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        if (customers.isEmpty()) {
            throw new ResourceNotFoundException("No customers found");
        }

        return customers.stream()
                .map(CustomMapper::customerToCustomerDTO)
                .toList();
    }

    @Override
    public List<CustomerDTO> getCustomersByCity(String city) {
        List<CustomerDTO> customers = addressRepository.findByCityIgnoreCase(city)
                .stream()
                .map(DeliveryAddress::getCustomer)
                .distinct()
                .map(CustomMapper::customerToCustomerDTO)
                .toList();

        if (customers.isEmpty()) {
            throw new ResourceNotFoundException("No customers found in city: " + city);
        }

        return customers;
    }

    @Override
    public Integer getAddressCount(Integer customerId) {
        return addressRepository.countByCustomerCustomerId(customerId);
    }

    @Override
    public Map<String, Object> getCustomerAnalytics(Integer customerId) {

        List<OrderItemDetailDTO> items =
                orderRepository.getOrderDetailsByCustomerId(customerId);

        if (items == null || items.isEmpty()) {
            throw new ResourceNotFoundException("No order data found for customer id: " + customerId);
        }

        Integer totalOrders = (int) items.stream()
                .map(OrderItemDetailDTO::getOrderDate)
                .distinct()
                .count();

        Double totalSpend = items.stream()
                .mapToDouble(i -> i.getQuantity() * i.getItemPrice().doubleValue())
                .sum();

        Double avgOrderValue = totalOrders == 0
                ? 0.0
                : totalSpend / totalOrders;

        Map<String, Object> response = new HashMap<>();
        response.put("totalOrders", totalOrders);
        response.put("totalSpend", totalSpend);
        response.put("avgOrderValue", avgOrderValue);

        return response;
    }
}