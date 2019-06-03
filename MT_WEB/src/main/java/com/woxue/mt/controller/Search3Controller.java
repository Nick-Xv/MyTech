package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.Patent;
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
@RequestMapping("/search3")
public class Search3Controller {
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
        SqlDealer.Order order = SqlDealer.Order.DEFAULT;
        String filter = request.getParameter("filter");
        String sorter = request.getParameter("sorter");
        String startYear = "0000";
        if(filter != null){
            if(filter.equals("1")){
                startYear = "2019";
            }
            else if(filter.equals("2")){
                startYear = "2018";
            }
            else if(filter.equals("3")){
                startYear = "2017";
            }
            else if(filter.equals("4")){
                startYear = "2016";
            }
            else if(filter.equals("5")){
                startYear = "2015";
            }
        }
        if(sorter != null){
            if(sorter.equals("1")){
                order = SqlDealer.Order.RECENT;

            }
        }

        if(mode.equals("false")){
            try {
                System.out.println(keywords);
                SqlDealer sqlDealer = new SqlDealer();
                List<Patent> result = sqlDealer.searchPatent(keywords,st,st+20);
                model.addAttribute("patentList",result);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            List<String> keywordl = new ArrayList<String>();
            List<String> authorl = new ArrayList<String>();
            List<String> idl = new ArrayList<String>();
            String author = request.getParameter("author");
            String keyword = request.getParameter("author2");
            String number = request.getParameter("number");
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            if(number == null || number.equals("undefined")){
                number = null;
                idl = null;
            }
            else{
                for(String rec: number.split(" ")){
                    if(!rec.equals("")){
                        idl.add(rec);
                    }
                }
                if(idl.size()==0){
                    idl = null;
                }
            }
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
            if(date1 == null || date1.equals("") || date1.equals("undefined")){
                date1 = "1970-01-01";
            }
            if(date2 == null || date2.equals("") || date2.equals("undefined")){
                date2 = "2099-12-31";
            }
            try {
                System.out.println(keywords);
                System.out.println(keywordl);
                System.out.println(authorl);
                System.out.println(date1);
                System.out.println(date2);
                SqlDealer sqlDealer = new SqlDealer();
                List<Patent> result = sqlDealer.advancedSearchPatent(keywords,authorl,keywordl,idl,date1,date2,st,st+20);
                model.addAttribute("patentList",result);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return "search3";
    }
}
