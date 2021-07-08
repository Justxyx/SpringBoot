package com.xm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class RestfulController {
    @RequestMapping("/restful/{id}")
    public Integer restful(@PathVariable("id") Integer id){
        System.out.println(id);
        return id;
    }
}
