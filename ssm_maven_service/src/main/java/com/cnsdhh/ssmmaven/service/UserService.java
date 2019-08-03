package com.cnsdhh.ssmmaven.service;

import com.cnsdhh.ssmmaven.pojo.User;

public interface UserService {

    // 查询登录用户信息
    public User login(String username, String password);

    // 添加登录用户信息
    public Integer register(User user);

}
