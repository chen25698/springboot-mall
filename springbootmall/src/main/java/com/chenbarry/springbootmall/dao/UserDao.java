package com.chenbarry.springbootmall.dao;

import com.chenbarry.springbootmall.dto.UserRegisterRequest;
import com.chenbarry.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);
}
