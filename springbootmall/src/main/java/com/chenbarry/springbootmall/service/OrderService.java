package com.chenbarry.springbootmall.service;

import java.util.List;

import com.chenbarry.springbootmall.dto.CreateOrderRequest;
import com.chenbarry.springbootmall.dto.OrderQueryParams;
import com.chenbarry.springbootmall.model.Order;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);
    
    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
