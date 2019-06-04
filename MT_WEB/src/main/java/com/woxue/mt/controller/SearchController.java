package com.woxue.mt.controller;
import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.Professor;
import com.woxue.mt.sqldealer.SqlDealer;
import com.woxue.mt.sqldealer.Thesis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
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
        try{
            SqlDealer sqlDealer = new SqlDealer();
            List<Thesis> trend =  new ArrayList<>();
            trend = sqlDealer.searchThesisRecommandedByReferenceCount(10);
            model.addAttribute("productList",trend);
            List<Professor> profList = new ArrayList<>();
            profList = sqlDealer.searchProfessorRecommandedByReferenceCount(5);
            for(Professor temp:profList){
                temp.setUrl("/MyTech/professor?id="+temp.getId());
            }
            model.addAttribute("profList",profList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "search";
    }
}
