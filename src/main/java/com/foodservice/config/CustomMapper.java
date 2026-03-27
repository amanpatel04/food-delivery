package com.foodservice.config;

import com.foodservice.entity.Customer;
import com.foodservice.entity.dto.CustomerDTO;

public class CustomMapper {

        public static CustomerDTO customerToCustomerDTO(Customer customer) {
            CustomerDTO dto = new CustomerDTO();
            dto.setCustomerName(customer.getCustomerName());
            dto.setCustomerEmail(customer.getCustomerEmail());
            dto.setCustomerPhone(customer.getCustomerPhone());
            return dto;
        }

        public static Customer customerDTOToCustomer(CustomerDTO dto) {
            Customer customer = new Customer();
            customer.setCustomerName(dto.getCustomerName());
            customer.setCustomerEmail(dto.getCustomerEmail());
            customer.setCustomerPhone(dto.getCustomerPhone());
            return customer;
        }
}
