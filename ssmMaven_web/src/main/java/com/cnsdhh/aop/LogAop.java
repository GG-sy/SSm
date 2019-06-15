package com.cnsdhh.aop;

import com.cnsdhh.domain.Log;
import com.cnsdhh.domain.User;
import com.cnsdhh.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    private final HttpServletRequest request;
    private final LogService logService;

    @Autowired
    public LogAop(HttpServletRequest request, LogService logService) {
        this.request = request;
        this.logService = logService;
    }

    @Around("execution(* com.cnsdhh.controller.*.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        Date start = new Date();
        Object proceed = pjp.proceed();
        long cost = new Date().getTime() - start.getTime();

        String username = "";
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            username = user.getUsername();
        } else {
            username = request.getParameter("username") + "[false]";
        }

        String className = pjp.getTarget().getClass().getName();
        String mothedName = pjp.getSignature().getName();

        Log log = new Log();
        log.setUsername(username);
        log.setTime(new Date());
        log.setUrl("[类名]" + className + "[方法名]" + mothedName);
        log.setCost(cost);

        logService.insertLog(log);

        return proceed;
    }
}
