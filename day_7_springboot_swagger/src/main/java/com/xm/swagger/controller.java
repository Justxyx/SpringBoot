package com.xm.swagger;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {

    @RequestMapping("/swagger")
    @ResponseBody
    public String swagger(){

        return "swagger";
    }
}
