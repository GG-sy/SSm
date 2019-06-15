package com.cnsdhh.controller;

import com.cnsdhh.domain.Student;
import com.cnsdhh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 查询所有记录
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> list = studentService.findAll();
//        for (Student student : list) {
//            System.out.println(student);
//        }
        modelAndView.addObject("list", list);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    // 添加学生信息
    @RequestMapping("/add")
    public String add(Student student, HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println(student);
        studentService.add(student);
        return "redirect:findAll.do";
    }

    // 查询一条记录
    @RequestMapping("/findOne")
    public String findOne(Integer id, Model model) {
        Student student = studentService.findOne(id);
        model.addAttribute("stu", student);
        return "update";
    }

    // 修改学生信息
    @RequestMapping("/update")
    public String update(Student student) {
        System.out.println(student);
        studentService.update(student);
        return "redirect:/student/findAll.do";
    }

    // 删除学生信息
    @RequestMapping("/delete")
    public String delete(Integer[] ids) {
        System.out.println(Arrays.toString(ids));
        studentService.delete(ids);
        return "redirect:/student/findAll.do";
    }
}
