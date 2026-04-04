package com.foodservice.frontend.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodservice.frontend.service.DeliveryDriverService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DeliveryDriverController {

    private final DeliveryDriverService service;

    // Drivers list
    @GetMapping
    public String getDrivers(Model model) {
        model.addAttribute("drivers", service.getAllDrivers());
        return "pages/driver/drivers";
    }

    // Driver details
    @GetMapping("/{id}")
    public String getDriver(@PathVariable Integer id, Model model) {
        model.addAttribute("driver", service.getDriverById(id));
        model.addAttribute("totalOrders", service.getTotalOrders(id));
        return "pages/driver/driver-details";
    }

    // Orders
    @GetMapping("/{id}/orders")
    public String getOrders(@PathVariable Integer id, Model model) {
        model.addAttribute("orders", service.getDriverOrders(id));
        return "pages/driver/driver-orders";
    }

    // Customers
    @GetMapping("/{id}/customers")
    public String getCustomers(@PathVariable Integer id, Model model) {
        model.addAttribute("customers", service.getDriverCustomers(id));
        return "pages/driver/driver-customers";
    }

    // Restaurants
    @GetMapping("/{id}/restaurants")
    public String getRestaurants(@PathVariable Integer id, Model model) {
        model.addAttribute("restaurants", service.getDriverRestaurants(id));
        return "pages/driver/driver-restaurants";
    }
}