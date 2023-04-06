package com.chenbarry.springbootmall.service;

import com.chenbarry.springbootmall.model.Product;
//建立object
public interface productService {
    Product getProductById(Integer productId);
}
