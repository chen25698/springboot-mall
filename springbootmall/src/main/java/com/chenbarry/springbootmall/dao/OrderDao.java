package com.chenbarry.springbootmall.dao;

import java.util.List;

import com.chenbarry.springbootmall.model.OrderItem;

public interface OrderDao {
    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
