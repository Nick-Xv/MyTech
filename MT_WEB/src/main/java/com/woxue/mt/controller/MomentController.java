package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/prof_moment")
public class MomentController {
    @RequestMapping(method = RequestMethod.GET)
    public String printSearch(ModelMap model, HttpSession session, User user){
        user = (User)session.getAttribute("user");
        if(user != null){
            model.addAttribute("login","欢迎！ "+ user.getName());
            model.addAttribute("jump","self");
        }
        else{
            model.addAttribute("login","登录");
            model.addAttribute("jump","to_login");
        }
        return "user_moment";
    }
}
