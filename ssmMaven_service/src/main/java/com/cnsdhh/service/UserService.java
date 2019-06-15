package com.cnsdhh.service;

import com.cnsdhh.domain.User;

public interface UserService {

    // 查询登录用户
    public User login(String username, String password);
}
