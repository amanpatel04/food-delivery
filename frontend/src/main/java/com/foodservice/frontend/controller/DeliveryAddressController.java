package com.foodservice.frontend.controller;
import com.foodservice.frontend.service.DeliveryAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class DeliveryAddressController {

    private final DeliveryAddressService deliveryAddressService;

    @GetMapping("/delivery-address/{addressId}")
    public String getAddressById(@PathVariable Integer addressId, Model model) {

        model.addAttribute("address", deliveryAddressService.getAddressById(addressId));
        return "pages/delivery-address/delivery-address-details";
    }

    @GetMapping("/delivery-address")
    public String getByCity(@RequestParam String city, Model model) {

        model.addAttribute("addresses", deliveryAddressService.getAddressesByCity(city));
        model.addAttribute("city", city);
        return "pages/delivery-address/delivery-address-list";
    }
}
