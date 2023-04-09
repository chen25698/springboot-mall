package com.chenbarry.springbootmall.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Integer userId;

    //@JsonProperty("e_mail") //客製化回傳給前端的欄位名
    private String email;

    @JsonIgnore             //將變數隱藏起來
    private String password;

    private Date CreatedDate;
    private Date lastModifiedDate;

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreatedDate() {
        return CreatedDate;
    }
    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
}
