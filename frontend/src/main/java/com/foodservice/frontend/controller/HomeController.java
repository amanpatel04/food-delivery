package com.foodservice.frontend.controller;

import com.foodservice.frontend.entity.dto.OrderCustomerDTO;
import com.foodservice.frontend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping
    public String home() {
        return "<h2> Welcome to spring boot frotend application. </h2>";
    }
}
