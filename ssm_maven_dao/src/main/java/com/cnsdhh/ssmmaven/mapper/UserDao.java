package com.cnsdhh.ssmmaven.mapper;

import com.cnsdhh.ssmmaven.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    // 查询登录用户信息
    @Select("select * from t_user where username = #{username} and password = #{password}")
    public User login(@Param("username") String username, @Param("password") String password);

    // 添加登录用户信息
    @Insert("insert into t_user values (#{id}, #{username}, #{password})")
    public Integer register(User user);

}
