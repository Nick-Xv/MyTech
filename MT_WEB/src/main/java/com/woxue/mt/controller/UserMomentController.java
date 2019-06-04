package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/user_moment")
public class UserMomentController {
    @RequestMapping(method = RequestMethod.GET)
    public String printSearch2(HttpServletRequest request, ModelMap model, HttpSession session, User user) throws Exception{
        user = (User)session.getAttribute("user");
        String judge = user.getCharacter();
        if(!judge.equals("专家用户")){
            model.addAttribute("hidden","hidden");
        }
        else{
            model.addAttribute("hidden","");
        }
        try{
            SqlDealer sqlDealer = new SqlDealer();
            List<Trend> listTrend = sqlDealer.searchTrendByUserId(user.getId());
            model.addAttribute("list",listTrend);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "user_moment";
    }
}
