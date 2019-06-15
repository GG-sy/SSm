package com.cnsdhh.dao;

import com.cnsdhh.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    // 查询登录用户
    @Select("select * from t_user where username = #{username} and password = #{password}")
    public User login(@Param("username") String username, @Param("password") String password);
}
