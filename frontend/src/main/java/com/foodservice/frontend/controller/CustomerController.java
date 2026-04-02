package com.foodservice.frontend.controller;

import com.foodservice.frontend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public String getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        model.addAttribute("customers", customerService.getAllCustomers(page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        return "pages/customer/customers";
    }

    @GetMapping("/customers/{id}")
    public String getCustomerById(@PathVariable Integer id, Model model) {

        model.addAttribute("customer", customerService.getCustomerById(id));
        return "pages/customer/customer-detail";
    }

    @GetMapping("/customers/{id}/addresses")
    public String getAddresses(@PathVariable Integer id, Model model) {

        model.addAttribute("addresses", customerService.getAddresses(id));
        return "pages/customer/addresses";
    }

    @GetMapping("/customers/{id}/orders")
    public String getOrders(@PathVariable Integer id, Model model) {

        model.addAttribute("orders", customerService.getOrders(id));
        return "pages/customer/customer-orders";
    }

    @GetMapping("/customers/{id}/analytics")
    public String getAnalytics(@PathVariable Integer id, Model model) {

        model.addAttribute("analytics", customerService.getAnalytics(id));
        return "pages/customer/analytics";
    }
}