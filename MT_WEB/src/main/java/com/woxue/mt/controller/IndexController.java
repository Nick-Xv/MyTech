package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller("indexController")
//@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/index")
    public String printIndex(HttpServletRequest request, ModelMap model, HttpSession session, User user){
        user = (User)session.getAttribute("user");
        if(user != null){
            model.addAttribute("login","欢迎！ "+ user.getName());
            model.addAttribute("jump","self");
        }
        else{
            model.addAttribute("login","登录");
            model.addAttribute("jump","to_login");
        }
        //model.addAttribute("messag","Hello Spring MVC Framework!");
        return "index";
    }
}
