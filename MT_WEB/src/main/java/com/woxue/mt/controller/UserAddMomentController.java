package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.SqlDealer;
import com.woxue.mt.sqldealer.Trend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
@RequestMapping("/user_add_moment")
public class UserAddMomentController {
    @RequestMapping(method = RequestMethod.GET)
    public String printSearch1(HttpServletRequest request, ModelMap model, HttpSession session, User user) throws Exception{
        String content = request.getParameter("content");
        String type = request.getParameter("type");
        String tid = request.getParameter("tid");
        if(content != null && type == null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp time1 = new Timestamp(new Date().getTime());
            String time = df.format(time1);
            Trend t = new Trend();
            t.setPublishTime(time);
            user = (User)session.getAttribute("user");
            t.setProfessorId(user.getId());
            t.setContent(content);
            try{
                SqlDealer sqlDealer = new SqlDealer();
                t.setProfName(sqlDealer.searchProfessorById(user.getId()).getName());
                sqlDealer.insertTrend(t);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(content != null && type .equals("1")){//修改
            user = (User)session.getAttribute("user");
            try{
                SqlDealer sqlDealer = new SqlDealer();
                sqlDealer.updateTrendById(tid,content);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(content != null && type .equals("0")){//显示
            content = content.replaceAll("<br/>", "\n");
            content = content.replaceAll("<br/>", "\r");
            model.addAttribute("texttext",content);
            model.addAttribute("tid",tid);
        }

        return "user_add_moment";
    }
}
