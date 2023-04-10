package com.chenbarry.springbootmall.service;

import com.chenbarry.springbootmall.dto.CreateOrderRequest;
import com.chenbarry.springbootmall.model.Order;

public interface OrderService {
    
    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
