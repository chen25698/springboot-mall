package com.chenbarry.springbootmall.service;

import java.util.List;

import com.chenbarry.springbootmall.dto.ProductRequest;
import com.chenbarry.springbootmall.model.Product;
//建立object
public interface productService {

    List<Product> getProducts();

    Product getProductById(Integer productId);

    //新增商品功能
    Integer createProduct(ProductRequest productRequest);

    //修改商品功能
    void updateProduct(Integer productId,ProductRequest productRequest);

    //刪除商品功能
    void deleteProductById(Integer productId);
}
