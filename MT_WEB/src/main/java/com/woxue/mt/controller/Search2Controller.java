package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
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
@RequestMapping("/search2")
public class Search2Controller {
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
        System.out.println(title);
        List<String> keywords = new ArrayList<String>();
        for(String rec: title.split(" ")){
            System.out.println(rec);
            keywords.add(rec);
        }
        try {
            System.out.println(keywords);
            SqlDealer sqlDealer = new SqlDealer();
            List<Thesis> result = sqlDealer.searchThesisAnd(keywords);
            model.addAttribute("productList",result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "search2";
    }
}
