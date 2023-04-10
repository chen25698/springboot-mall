package com.chenbarry.springbootmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chenbarry.springbootmall.dto.CreateOrderRequest;
import com.chenbarry.springbootmall.model.Order;
import com.chenbarry.springbootmall.service.OrderService;
import com.chenbarry.springbootmall.util.Page;
import com.chenbarry.springbootmall.dto.OrderQueryParams;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<Order>> getOrders(
        @PathVariable Integer userId,
        @RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit,
        @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        OrderQueryParams orderQueryParams = new OrderQueryParams();
        orderQueryParams.setUserId(userId);
        orderQueryParams.setLimit(limit);
        orderQueryParams.setOffset(offset);

        List<Order> orderList = orderService.getOrders(orderQueryParams);

        Integer count = orderService.countOrder(orderQueryParams);

        Page<Order> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(count);
        page.setResults(orderList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    //使用者一定是有帳號才會購買，才會有訂單
    @PostMapping("/users/{userId}/orders")
    //先使用PathVariable接住userId
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                            @RequestBody @Valid CreateOrderRequest createOrderRequest){
    Integer orderId = orderService.createOrder(userId,createOrderRequest);

    Order order = orderService.getOrderById(orderId);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
