package com.CMe388.controller;

import com.CMe388.pojo.User;
import com.CMe388.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        if (user.getUsername() == null || user.getPassword() == null) {
            request.setAttribute("msg", "用户名或密码为空");
            return "/admin/login";
        }
        try {
            User u = userService.login(user);
            if (u != null) {
                request.getSession().setAttribute("USER_SESSION", u);
                return "redirect:/main";
            }
            request.setAttribute("msg", "用户名或密码错误");
            return "/admin/login";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "系统错误");
            return "/admin/login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }

    @RequestMapping("/register")
    @ResponseBody
    public Integer register(User user) {
        if (user.getUsername() == null || "".equals(user.getUsername())) {
            return 0;
        }
        if (user.getPassword() == null || "".equals(user.getPassword())) {
            return 0;
        }
        try {
            User uByName = userService.findUserByName(user.getUsername());
            if (uByName != null) {
                return 400;
            }
            return userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @RequestMapping("/findAllUser")
    @ResponseBody
    public List<User> findAllUser() {
        return userService.findAllUser();
    }
}
