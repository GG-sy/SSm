package com.cnsdhh.service.impl;

import com.cnsdhh.dao.StudentDao;
import com.cnsdhh.domain.Student;
import com.cnsdhh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    // 查询所有记录
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    // 添加学生信息
    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    // 查询一条记录
    @Override
    public Student findOne(Integer id) {
        return studentDao.findOne(id);
    }

    // 修改学生信息
    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    // 删除学生信息
    @Override
    public void delete(Integer[] ids) {
        //studentDao.delete(ids); // 使用数组时
        studentDao.delete(Arrays.asList(ids)); // 使用集合时
    }
}
