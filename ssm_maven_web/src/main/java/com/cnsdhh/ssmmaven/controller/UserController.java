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

    // 查询登录用户（POST方式）
    // testURL : http://localhost:8082/user/login.html
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
                    return resultMap;
                }
            } catch (Exception e) {
                return resultMap;
            }
        } else {
            resultMap.put("mssg", "请输入用户名或密码才能登录！");
            return resultMap;
        }
    }

    // 查询登录用户（GET方式）
    // testURL : http://localhost:8082/user/login.do?username=admin&password=admin
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
                    return resultMap;
                }
            } catch (Exception e) {
                return resultMap;
            }
        } else {
            resultMap.put("mssg", "请输入用户名或密码才能登录！");
            return resultMap;
        }
    }

}
