package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.ProfessorOwnThesis;
import com.woxue.mt.sqldealer.SqlDealer;
import com.woxue.mt.sqldealer.Thesis;
import com.woxue.mt.sqldealer.Trend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

        String id = request.getParameter("id");
        String start = request.getParameter("start");
        String name = request.getParameter("name");
        if(start == null){
            start = "20";
        }
        int st = Integer.parseInt(start);
        st -= 20;
        if(id!=null) {
            try {
                model.addAttribute("name", name);
                SqlDealer sqlDealer = new SqlDealer();
                List<Trend> tList = sqlDealer.searchTrendByUserId2(id);
                Thesis tempT = new Thesis();
                if (tList.size() != 0) {
                    model.addAttribute("momentList", tList);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "professor_moment";
    }
}
