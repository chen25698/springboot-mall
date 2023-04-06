package com.chenbarry.springbootmall.service;

import com.chenbarry.springbootmall.dto.ProductRequest;
import com.chenbarry.springbootmall.model.Product;
//建立object
public interface productService {
    Product getProductById(Integer productId);

    //新增商品功能
    Integer createProduct(ProductRequest productRequest);
}
