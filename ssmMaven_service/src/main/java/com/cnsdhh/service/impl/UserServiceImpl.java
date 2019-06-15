package com.cnsdhh.service.impl;

import com.cnsdhh.dao.UserDao;
import com.cnsdhh.domain.User;
import com.cnsdhh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// 只是一个查询，用不用事务都行
//@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // 查询登录用户
    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
