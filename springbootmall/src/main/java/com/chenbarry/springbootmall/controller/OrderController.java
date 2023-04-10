package com.chenbarry.springbootmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenbarry.springbootmall.dto.CreateOrderRequest;
import com.chenbarry.springbootmall.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    //使用者一定是有帳號才會購買，才會有訂單
    @PostMapping("/users/{userId}/orders")
    //先使用PathVariable接住userId
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                            @RequestBody @Valid CreateOrderRequest createOrderRequest){
    Integer orderId = orderService.createOrder(userId,createOrderRequest);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }
}
