package com.cnsdhh.controller;

import com.cnsdhh.domain.User;
import com.cnsdhh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final HttpServletRequest request;

    @Autowired
    public UserController(UserService userService, HttpServletRequest request) {
        this.userService = userService;
        this.request = request;
    }

    // 查询登录用户
    @RequestMapping("/login")
    public String login(String username, String password) {
        User login = userService.login(username, password);
        System.out.println(login);
        if (login != null) {
            request.getSession().setAttribute("user", login);
            return "redirect:/student/findAll.do";
        } else {
            request.setAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }
}
