package com.cnsdhh.service;

import com.cnsdhh.domain.Student;

import java.util.List;

public interface StudentService {

    // 查询所有记录
    public List<Student> findAll();

    // 添加学生信息
    public void add(Student student);

    // 查询一条记录
    public Student findOne(Integer id);

    // 修改学生信息
    public void update(Student student);

    // 删除学生信息
    public void delete(Integer[] ids);
}
