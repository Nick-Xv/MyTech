package com.woxue.mt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("indexController")
//@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/index")
    public String printIndex(ModelMap model){
        //model.addAttribute("messag","Hello Spring MVC Framework!");
        return "index";
    }
}
