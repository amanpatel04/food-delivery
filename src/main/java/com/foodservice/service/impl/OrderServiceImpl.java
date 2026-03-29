package com.foodservice.service.impl;

import com.foodservice.config.CustomMapper;
import com.foodservice.entity.Customer;
import com.foodservice.entity.Order;
import com.foodservice.entity.dto.OrderCustomerDTO;
import com.foodservice.entity.dto.OrderDTO;
import com.foodservice.entity.dto.OrderItemDetailDTO;
import com.foodservice.exception.OrderInvalidRequestException;
import com.foodservice.exception.OrderInvalidRequestException;
import com.foodservice.repository.CustomerRepository;
import com.foodservice.repository.OrderRepository;
import com.foodservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Override
    public OrderDTO getOrderDetailsById(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderInvalidRequestException("Order not found having order id: " + orderId));
        List<OrderItemDetailDTO> orderDetails = orderRepository.getOrderDetailsByOrderId(orderId);
        Order order = orderRepository.findById(orderId).orElse(null);
        List<OrderItemDetailDTO> orderDetails = orderRepository.getOrderDetailsByOrderId(orderId);
        OrderDTO orderDTO = CustomMapper.orderToOrderDTO(order, new OrderDTO());
        orderDTO.setOrderItems(orderDetails);
        return orderDTO;
    }

    @Override
    public OrderCustomerDTO getOrdersByCustomerId(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new OrderInvalidRequestException("Customer do next exist having customer id: " + customerId));
        Customer customer = customerRepository.findById(customerId).orElse(null);
        List<OrderItemDetailDTO> orderDetails = orderRepository.getOrderDetailsByCustomerId(customerId);
        OrderCustomerDTO orderDTO = new OrderCustomerDTO();
        orderDTO.setCustomer(customer);
        orderDTO.setOrderItems(orderDetails);
        return orderDTO;
    }
}
