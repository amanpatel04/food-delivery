package com.foodservice.frontend.controller;

import com.foodservice.frontend.entity.dto.OrderCustomerDTO;
import com.foodservice.frontend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/customer/{customerId}")
    public String getOrdersByCustomerId(@PathVariable("customerId") Integer customerId,
                                        Model model,
                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                                        @CookieValue(name = "token", required = false) String token
    ) {

        OrderCustomerDTO orderCustomerDTO = orderService.getOrdersByCustomerId(customerId, page, size, token);

        model.addAttribute("orderCustomerDTO", orderCustomerDTO);
        return "pages/orders";
    }
}
