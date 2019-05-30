package com.woxue.mt.controller;

import com.woxue.mt.biz.AdminBiz;
import com.woxue.mt.biz.GlobalBiz;
import com.woxue.mt.biz.ProfessorBiz;
import com.woxue.mt.biz.UserBiz;
import com.woxue.mt.entity.User;
import com.woxue.mt.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class SearchController {
    @Autowired
    private GlobalBiz globalBiz;
    @Autowired
    private ProfessorBiz professorBiz;
    @Autowired
    private AdminBiz adminBiz;
    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/search")
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
        return "search";
    }
}
