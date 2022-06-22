package com.CMe388.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI().toLowerCase();
        //获取请求路径并转换成小写
        if (uri.contains("login") || uri.contains("register") || uri.contains("main")) {
            return true;
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("USER_SESSION") != null) {
            return true;
        }
        request.setAttribute("msg", "您还没有登入，请先登录！");
        request.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp").forward(request, response);
        return false;
    }
}