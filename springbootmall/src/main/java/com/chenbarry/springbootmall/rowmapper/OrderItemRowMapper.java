package com.chenbarry.springbootmall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.chenbarry.springbootmall.model.OrderItem;


public class OrderItemRowMapper implements RowMapper<OrderItem>{
    //JOIN多張Table時，RowMapper不會管是哪張Table的欄位，只要對應到名稱就好
    @Override
    @Nullable
    public OrderItem mapRow(ResultSet resultSet, int i) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(resultSet.getInt("order_item_id"));
        orderItem.setOrderId(resultSet.getInt("order_id"));
        orderItem.setProductId(resultSet.getInt("product_id"));
        orderItem.setQuantity(resultSet.getInt("quantity"));
        orderItem.setAmount(resultSet.getInt("amount"));

        orderItem.setProductName(resultSet.getString("product_name"));
        orderItem.setImageUrl(resultSet.getString("image_url"));

        return orderItem;
    }
    
    
}
