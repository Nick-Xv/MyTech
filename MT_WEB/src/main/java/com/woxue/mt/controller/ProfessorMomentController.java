package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/professor_moment")
public class ProfessorMomentController {
    @RequestMapping(method = RequestMethod.GET)
    public String printEssay(HttpServletRequest request, ModelMap model, HttpSession session, User user) {
        user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("login", "欢迎！ " + user.getName());
            model.addAttribute("jump", "self");
        } else {
            model.addAttribute("login", "登录");
            model.addAttribute("jump", "to_login");
        }

        return "professor_moment";
    }
}
