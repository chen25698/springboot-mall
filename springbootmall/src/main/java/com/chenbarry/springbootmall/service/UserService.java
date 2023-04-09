package com.chenbarry.springbootmall.service;

import com.chenbarry.springbootmall.dto.UserRegisterRequest;
import com.chenbarry.springbootmall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
