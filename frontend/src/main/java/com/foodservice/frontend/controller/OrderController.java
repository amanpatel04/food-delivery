package com.foodservice.frontend.controller;

import com.foodservice.frontend.entity.dto.OrderCustomerDTO;
import com.foodservice.frontend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/customer/{customerId}")
    public String getOrdersByCustomerId(@PathVariable("customerId") Integer customerId,
                                        Model model,
                                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                                        @RequestParam(name = "status") String status,
                                        @RequestParam(name = "sort") String sort
    ) {
        OrderCustomerDTO orderCustomerDTO = orderService.getOrdersByCustomerId(customerId, page, size, status, sort);

        model.addAttribute("orderCustomerDTO", orderCustomerDTO);
        return "pages/orders";
    }
}
