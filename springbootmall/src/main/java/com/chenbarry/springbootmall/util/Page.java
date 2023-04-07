package com.chenbarry.springbootmall.util;

import java.util.List;

public class Page<T> {
    
    private Integer limit;
    private Integer offset;
    private Integer total;
    private List<T> resalts;
    
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
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public List<T> getResalts() {
        return resalts;
    }
    public void setResalts(List<T> resalts) {
        this.resalts = resalts;
    }

    
}
