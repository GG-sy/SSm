package com.cnsdhh.ssmmaven.service;

import com.cnsdhh.ssmmaven.pojo.User;

public interface UserService {

    // 查询登录用户
    public User login(String username, String password);

}
