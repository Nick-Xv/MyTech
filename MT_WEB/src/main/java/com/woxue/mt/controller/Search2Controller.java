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
        String start = request.getParameter("start");
        if(start == null){
            start = "20";
        }
        int st = Integer.parseInt(start);
        st -= 20;
        String mode = request.getParameter("mode");
        if(mode == null){
            mode = "false";
        }
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
        int filterInt,sortInt;
        String filter = request.getParameter("filter");
        if(filter == null){
            filterInt=0;
        }
        else{
            if(filter.equals("10")){
                filterInt = 0;
                //
            }
            else{
                filterInt = Integer.parseInt(filter);
                //
            }
        }

        if(mode.equals("false")){
            try {
                System.out.println(keywords);
                SqlDealer sqlDealer = new SqlDealer();
                List<Thesis> result = sqlDealer.searchThesisAnd(keywords,st,st+20);
                model.addAttribute("productList",result);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            List<String> keywordl = new ArrayList<String>();
            List<String> authorl = new ArrayList<String>();
            String author = request.getParameter("author");
            String keyword = request.getParameter("keyword");
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            if(author == null || author.equals("undefined")){
                author = null;
                authorl = null;
            }
            else{
                for(String rec: author.split(" ")){
                    if(!rec.equals("")){
                        authorl.add(rec);
                    }
                }
                if(authorl.size()==0){
                    authorl = null;
                }
            }
            if(keyword == null || keyword.equals("undefined")){
                keyword = null;
                keywordl=null;
            }
            else{
                for(String rec: keyword.split(" ")){
                    if(!rec.equals("")){
                        keywordl.add(rec);
                    }
                }
                if(keywordl.size()==0){
                    keywordl = null;
                }
            }
            if(date1 == null || date1.equals("undefined")){
                date1 = null;
            }
            else{
                date1 = date1.split("-")[0];
            }
            if(date2 == null || date2.equals("undefined")){
                date2 = null;
            }
            else{
                date2 = date2.split("-")[0];
            }

            try {
                System.out.println(keywords);
                System.out.println(keywordl);
                System.out.println(authorl);
                System.out.println(date1);
                System.out.println(date2);
                SqlDealer sqlDealer = new SqlDealer();
                List<Thesis> result = sqlDealer.searchThesisAnd(keywords,st,st+20);
                model.addAttribute("productList",result);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(st);
        System.out.println(title);
        return "search2";
    }
}
