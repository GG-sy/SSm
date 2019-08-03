package com.cnsdhh.ssmmaven.controller;

import com.cnsdhh.ssmmaven.pojo.User;
import com.cnsdhh.ssmmaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 用户登录（POST方式）
    // testURL : http://localhost:8080/static/user/login.html
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Map login(@RequestBody User user, HttpServletRequest request) {
        Map<String, Object> resultMap = BaseController.getResultMap();
        BaseController.ifLogin(request);  // 删除登录状态
        if (user != null) {
            String username = user.getUsername();
            String password = user.getPassword();
            try {
                User loginUser = userService.login(username, password);
                if (loginUser != null) {
                    request.getSession().setAttribute("loginUser", loginUser);
                    resultMap.put("sign", true);
                    resultMap.put("mssg", "成功");
                    return resultMap;
                } else {
                    resultMap.put("mssg", "用户名或密码错误");
                    return resultMap;
                }
            } catch (Exception e) {
                resultMap.put("mssg", "服务器出错");
                return resultMap;
            }
        } else {
            resultMap.put("mssg", "请输入用户名或密码才能登录");
            return resultMap;
        }
    }

    // 用户登录（GET方式）
    // testURL : http://localhost:8080/static/user/login.do?username=admin&password=admin
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody Map login(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            HttpServletRequest request) {
        Map<String, Object> resultMap = BaseController.getResultMap();
        BaseController.ifLogin(request);  // 删除登录状态
        if (username != null && password != null && !"".equalsIgnoreCase(username) && !"".equalsIgnoreCase(password)) {
            try {
                User loginUser = userService.login(username, password);
                if (loginUser != null) {
                    request.getSession().setAttribute("loginUser", loginUser);
                    resultMap.put("sign", true);
                    resultMap.put("mssg", "成功");
                    return resultMap;
                } else {
                    resultMap.put("mssg", "用户名或密码错误");
                    return resultMap;
                }
            } catch (Exception e) {
                resultMap.put("mssg", "服务器出错");
                return resultMap;
            }
        } else {
            resultMap.put("mssg", "请输入用户名或密码才能登录");
            return resultMap;
        }
    }

    // 用户注册（POST方式）
    // testURL : http://localhost:8080/static/user/register.html
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Map register(@RequestBody User user) {
        Map<String, Object> resultMap = BaseController.getResultMap();
        if (user != null) {
            try {
                Integer status = userService.register(user);
                return BaseController.ifStatus(status, resultMap);
            } catch (Exception e) {
                resultMap.put("mssg", "服务器出错");
                return resultMap;
            }
        } else {
            resultMap.put("mssg", "请输入用户名和密码才能注册");
            return resultMap;
        }
    }

}
