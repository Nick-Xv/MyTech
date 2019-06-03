package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.Patent;
import com.woxue.mt.sqldealer.SqlDealer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/patent")
public class PatentController {
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
        String id = request.getParameter("id");
        if(id == null || id == ""){
            model.addAttribute("title","数据库中没有此专利");
        }
        else {
            try{
                SqlDealer sqlDealer = new SqlDealer();
                Patent patent = new Patent();
                patent = sqlDealer.searchPatentById(id);
                if(patent != null){
                    model.addAttribute("id",patent.getId());
                    model.addAttribute("title",patent.getName());
                    model.addAttribute("author",patent.getInventor());
                    model.addAttribute("author1",patent.getApplicant());
                    model.addAttribute("addr",patent.getAddress());
                    model.addAttribute("agentins",patent.getAgency());
                    model.addAttribute("agent",patent.getAgent());
                    model.addAttribute("main",patent.getMainClass());
                    model.addAttribute("sub",patent.getPatentClass());
                    model.addAttribute("info",patent.getSummary());
                    model.addAttribute("items",patent.getIndependentClaim());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "patent";
    }
}
