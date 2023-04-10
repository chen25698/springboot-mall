package com.chenbarry.springbootmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.chenbarry.springbootmall.dao.OrderDao;
import com.chenbarry.springbootmall.dao.UserDao;
import com.chenbarry.springbootmall.dto.BuyItem;
import com.chenbarry.springbootmall.dto.CreateOrderRequest;
import com.chenbarry.springbootmall.model.Order;
import com.chenbarry.springbootmall.model.OrderItem;
import com.chenbarry.springbootmall.model.Product;
import com.chenbarry.springbootmall.model.User;
import com.chenbarry.springbootmall.service.OrderService;
import com.chenbarry.springbootmall.dao.productDao;

@Component
public class OrderServiceImpl implements OrderService{
    
private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    //注入多個dao使用裡面的sql
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private productDao productDao;

    @Autowired
    private UserDao userDao;

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
        
        User user = userDao.getUserById(userId);
        
        if(user == null){
            log.warn("該 userId {} 不存在", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            //檢查 product 是否存在，庫存是否足夠
            if(product == null){
                log.warn("商品 {} 不存在", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                
            }else if(product.getStock() < buyItem.getQuantity()){
                log.warn("商品 {} 庫存數量不足，剩餘庫存 {} ，欲購買數量 {} ", 
                buyItem.getProductId(),product.getStock(),buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            //扣除商品庫存
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());


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
