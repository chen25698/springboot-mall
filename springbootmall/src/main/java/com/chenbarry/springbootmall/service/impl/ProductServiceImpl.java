package com.chenbarry.springbootmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chenbarry.springbootmall.dao.productDao;
import com.chenbarry.springbootmall.model.Product;
import com.chenbarry.springbootmall.service.productService;

@Component
public class ProductServiceImpl implements productService {
    @Autowired
    private productDao productDao;

    @Override
    public Product getProductById(Integer productId) {

        return productDao.getProductById(productId);
    }
}
