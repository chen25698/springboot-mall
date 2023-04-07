package com.chenbarry.springbootmall.dto;

import com.chenbarry.springbootmall.constant.ProductCategory;

//將冗長的查詢條件集中，增加可讀性，保留擴充性
public class ProductQueryParams {
    private ProductCategory category;
    private String serch;

    public ProductCategory getCategory() {
        return category;
    }
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    public String getSerch() {
        return serch;
    }
    public void setSerch(String serch) {
        this.serch = serch;
    }

    
}
