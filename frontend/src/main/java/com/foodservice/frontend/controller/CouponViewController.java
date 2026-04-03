package com.foodservice.frontend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.foodservice.frontend.entity.dto.OrderCouponDTO;
import com.foodservice.frontend.service.CouponClientService;

@Controller
@RequestMapping("/view/orders")
public class CouponViewController {

    private final CouponClientService couponClientService;

    public CouponViewController(CouponClientService couponClientService) {
        this.couponClientService = couponClientService;
    }


    @GetMapping
    public String showPage() {
        return "coupons";   //no layout direct page
    }

    @GetMapping("/coupons")
    public String getCoupons(@RequestParam int orderId,
                             Model model,
                             @CookieValue(name = "token", required = true) String token) {

        System.out.println("TOKEN FROM COOKIE: " + token);

        try {
            List<OrderCouponDTO> coupons =
                    couponClientService.getCouponsByOrder(orderId, token);

            model.addAttribute("coupons", coupons);

        } catch (Exception e) {
            model.addAttribute("error", "No coupons found");
        }

        return "coupons";
    }
}