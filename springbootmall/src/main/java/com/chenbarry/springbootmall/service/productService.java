package com.chenbarry.springbootmall.service;

import java.util.List;

//import com.chenbarry.springbootmall.constant.ProductCategory;
import com.chenbarry.springbootmall.dto.ProductQueryParams;
import com.chenbarry.springbootmall.dto.ProductRequest;
import com.chenbarry.springbootmall.model.Product;
//建立object
public interface productService {

    Integer countProduct(ProductQueryParams productQueryParams);

    //查詢條件功能
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    //新增商品功能
    Integer createProduct(ProductRequest productRequest);

    //修改商品功能
    void updateProduct(Integer productId,ProductRequest productRequest);

    //刪除商品功能
    void deleteProductById(Integer productId);
}
