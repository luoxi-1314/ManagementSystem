package com.project2.again.config;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户的session
        Object loginUser =request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.setAttribute("msg","没有权限(⊙x⊙;)");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }

    }
}
