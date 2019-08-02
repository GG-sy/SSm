package com.cnsdhh.ssmmaven;

import com.cnsdhh.ssmmaven.pojo.Student;
import com.cnsdhh.ssmmaven.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-service.xml")
public class ServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void studentServiceFindAll() {
        List<Student> studentList = studentService.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void studentServiceFindOne() {
        Student student = studentService.findOne(3);
        System.out.println(student);
    }

}
