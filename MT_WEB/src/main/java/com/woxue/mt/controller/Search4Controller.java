package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.Professor;
import com.woxue.mt.sqldealer.SqlDealer;
import com.woxue.mt.sqldealer.Thesis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search4")
public class Search4Controller {
    @RequestMapping(method = RequestMethod.GET)
    public String printSearch2(HttpServletRequest request, ModelMap model, HttpSession session, User user) throws Exception{
        user = (User)session.getAttribute("user");
        if(user != null){
            model.addAttribute("login","欢迎！ "+ user.getName());
            model.addAttribute("jump","self");
        }
        else{
            model.addAttribute("login","登录");
            model.addAttribute("jump","to_login");
        }

        String title = request.getParameter("title");
        String start = request.getParameter("start");
        String sorter = request.getParameter("sorter");
        SqlDealer.Order order = SqlDealer.Order.DEFAULT;
        if(sorter != null){
            if(sorter.equals("1")){
                order = SqlDealer.Order.REFERENCE_COUNT;
            }
            else{
                order = SqlDealer.Order.WORK_NUM;
            }
        }
        if(start == null){
            start = "20";
        }
        int st = Integer.parseInt(start);
        st -= 20;
        List<String> keywords = new ArrayList<String>();
        for(String rec: title.split(" ")){
            System.out.println(rec);
            if(!rec.equals("")){
                keywords.add(rec);System.out.println("!");}
        }
        System.out.println(keywords.size());
        if(keywords.size()==0){
            keywords = null;
        }
        try {
            System.out.println(keywords);
            SqlDealer sqlDealer = new SqlDealer();
            List<Professor> result = sqlDealer.searchProfessor(keywords,st,st+20);
            model.addAttribute("professorList",result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "search4";
    }
}
