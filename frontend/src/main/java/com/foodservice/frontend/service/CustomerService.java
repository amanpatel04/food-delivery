package com.foodservice.frontend.service;

import com.foodservice.frontend.entity.dto.*;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers(int page, int size);

    CustomerDTO getCustomerById(Integer id);

    List<DeliveryAddressDTO> getAddresses(Integer id);

    List<OrderItemDetailDTO> getOrders(Integer id);

    Integer getAddressCount(Integer id);

    CustomerAnalyticsDTO getAnalytics(Integer id);
}
