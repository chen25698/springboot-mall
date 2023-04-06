package com.chenbarry.springbootmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chenbarry.springbootmall.dao.productDao;
import com.chenbarry.springbootmall.dto.ProductRequest;
import com.chenbarry.springbootmall.model.Product;
import com.chenbarry.springbootmall.service.productService;

@Component
public class ProductServiceImpl implements productService {
    @Autowired
    private productDao productDao;
    
    @Override
    public List<Product> getProducts() {
        
        return productDao.getProducts();
    }

    //固定寫法，實作介面方法
    @Override
    public Product getProductById(Integer productId) {

        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId,productRequest);
        
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
        
    }

    
}
