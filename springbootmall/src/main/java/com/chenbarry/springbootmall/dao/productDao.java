package com.chenbarry.springbootmall.dao;

import com.chenbarry.springbootmall.dto.ProductRequest;
import com.chenbarry.springbootmall.model.Product;

public interface productDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
