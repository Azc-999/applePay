package com.CMe388.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/Login")
    public String toLogin() {
        return "/admin/login";
    }

    @RequestMapping("/Register")
    public String toRegister() {
        return "/admin/register";
    }
}
