package com.xm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test1(Model model){
        model.addAttribute("msg","这是一个跳转的演示页面");
        model.addAttribute("users", Arrays.asList("user1","user2"));
        return "demo";
    }
}
