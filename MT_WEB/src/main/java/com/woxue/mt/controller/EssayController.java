package com.woxue.mt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/essay")
public class EssayController {
    @RequestMapping(method = RequestMethod.GET)
    public String printEssay(ModelMap model){
        //model.addAttribute("messag","Hello Spring MVC Framework!");
        return "essay";
    }
}
