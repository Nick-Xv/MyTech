package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.Comment;
import com.woxue.mt.sqldealer.SqlDealer;
import com.woxue.mt.sqldealer.Thesis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/essay")
public class EssayController {
    @RequestMapping(method = RequestMethod.GET)
    public String printEssay(HttpServletRequest request, ModelMap model, HttpSession session, User user){
        user = (User)session.getAttribute("user");
        if(user != null){
            model.addAttribute("login","欢迎！ "+ user.getName());
            model.addAttribute("jump","self");
        }
        else{
            model.addAttribute("login","登录");
            model.addAttribute("jump","to_login");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp time1 = new Timestamp(new Date().getTime());
        String time = df.format(time1);

        model.addAttribute("id1","a123");
        model.addAttribute("id2","a-321");

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        String rating = request.getParameter("rating");

        if(id == null || id == ""){
            model.addAttribute("title","数据库中没有此论文");
        }
        else{
            try{
                SqlDealer sqlDealer = new SqlDealer();
                Thesis thesis = new Thesis();
                thesis = sqlDealer.searchThesisById(id);

                if(thesis != null){
                    model.addAttribute("id",thesis.getId());
                    model.addAttribute("title",thesis.getTitle());
                    model.addAttribute("authors",thesis.getAuthor());
                    model.addAttribute("info",thesis.getSummary());
                    model.addAttribute("keywords",thesis.getKeyword());
                    model.addAttribute("url",thesis.getUrl());
                }

                List<Comment> commentList = sqlDealer.searchCommentByThesisId(id);

                if(comment != null){
                    if(user == null){
                        return "login";
                    }
                    if(rating == null){
                        rating = "0";
                    }
                    Comment commentIns = new Comment();
                    commentIns.setContent(comment);
                    commentIns.setScore(Integer.parseInt(rating));
                    commentIns.setPublishTime(time);
                    commentIns.setUserId(user.getId());
                    commentIns.setThesisId(id);
                    sqlDealer.insertComment(commentIns);
                    commentList.add(commentIns);
                }
                int i=0;
                double sum = 0;
                if(commentList.size()!=0){
                    for(Comment temp:commentList){
                        if(temp.getScore()!=0){
                            sum += temp.getScore();
                            i++;
                        }
                    }
                    String grade = String.format("%.1f", sum/i);
                    model.addAttribute("grade",grade+"/5");
                    model.addAttribute("commentList",commentList);
                }
                else{
                    model.addAttribute("grade","暂无");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return "essay";
    }

    @ResponseBody
    @RequestMapping("/purchase")
    public String purchase(HttpServletRequest request){
        String id1 = request.getParameter("id1");
        String id2 = request.getParameter("id2");
        return "true";
    }

    @ResponseBody
    @RequestMapping("/confirm")
    public String confirm(HttpServletRequest request){
        String id1 = request.getParameter("id1");
        String id2 = request.getParameter("id2");
        return "true";
    }
}
