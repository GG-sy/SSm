package com.cnsdhh.dao;

import com.cnsdhh.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {

    // 查询所有记录
    public List<Student> findAll();

    // 添加学生信息
    public void add(Student student);

    // 查询一条记录
    @Select("select * from t_student where id = #{id}")
    public Student findOne(Integer id);

    // 修改学生信息
    @Select("update t_student set name=#{name}, sex=#{sex}, age=#{age}, address=#{address} where id=#{id}")
    public void update(Student student);

    // 删除学生信息
    //public void delete(Integer[] ids); // 使用数组时
    public void delete(List list); // 使用集合时
}
