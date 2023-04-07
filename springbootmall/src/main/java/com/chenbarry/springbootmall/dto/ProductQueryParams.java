package com.chenbarry.springbootmall.dto;

import com.chenbarry.springbootmall.constant.ProductCategory;

//將冗長的查詢條件集中，增加可讀性，保留擴充性
public class ProductQueryParams {
    private ProductCategory category;
    private String serch;
    private String orderBy;
    private String sort;
    private Integer limit;
    private Integer offset;

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
    public String getOrderBy() {
        return orderBy;
    }
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    public Integer getOffset() {
        return offset;
    }
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    
}
