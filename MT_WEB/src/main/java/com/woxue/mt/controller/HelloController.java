package com.woxue.mt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")
    public String printHello(ModelMap model){
        model.addAttribute("messag","Hello Spring MVC Framework!");
        return "hello";
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "123";
    }
}
