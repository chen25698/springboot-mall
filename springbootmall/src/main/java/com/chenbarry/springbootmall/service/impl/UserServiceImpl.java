package com.chenbarry.springbootmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chenbarry.springbootmall.dao.UserDao;
import com.chenbarry.springbootmall.dto.UserRegisterRequest;
import com.chenbarry.springbootmall.model.User;
import com.chenbarry.springbootmall.service.UserService;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        
        return userDao.getUserById(userId);
    }

    
}
