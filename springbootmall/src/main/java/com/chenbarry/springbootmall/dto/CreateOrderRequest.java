package com.chenbarry.springbootmall.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class CreateOrderRequest {
    //外層object，需要再增加一個class設計內層json，BuyItem
    @NotEmpty//不能為空值
    private List<BuyItem> buyItemList;

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    } 
    
}
