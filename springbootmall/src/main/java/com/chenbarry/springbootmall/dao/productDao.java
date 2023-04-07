package com.chenbarry.springbootmall.dao;

import java.util.List;

//import com.chenbarry.springbootmall.constant.ProductCategory;
import com.chenbarry.springbootmall.dto.ProductQueryParams;
import com.chenbarry.springbootmall.dto.ProductRequest;
import com.chenbarry.springbootmall.model.Product;

public interface productDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    //修改商品功能
    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
