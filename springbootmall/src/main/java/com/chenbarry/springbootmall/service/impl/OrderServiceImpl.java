package com.chenbarry.springbootmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.chenbarry.springbootmall.dao.OrderDao;
import com.chenbarry.springbootmall.dto.BuyItem;
import com.chenbarry.springbootmall.dto.CreateOrderRequest;
import com.chenbarry.springbootmall.model.Order;
import com.chenbarry.springbootmall.model.OrderItem;
import com.chenbarry.springbootmall.model.Product;
import com.chenbarry.springbootmall.service.OrderService;
import com.chenbarry.springbootmall.dao.productDao;

@Component
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private productDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);
        
        return order;
    }

    @Transactional  //噴出exception後，可以恢復已經做過的改動，特別是2個Table以上的改動
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            //計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        //創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId,orderItemList);

        return orderId;
    }

    
}
