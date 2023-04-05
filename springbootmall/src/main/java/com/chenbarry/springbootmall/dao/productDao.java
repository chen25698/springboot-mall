package com.chenbarry.springbootmall.dao;

import com.chenbarry.springbootmall.model.Product;

public interface productDao {
    Product getProductById(Integer productId);
}
