package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.Comment;
import com.woxue.mt.sqldealer.SqlDealer;
import com.woxue.mt.sqldealer.Thesis;
import com.woxue.mt.sqldealer.UserBuyThesis;
import net.sf.json.JSONObject;
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

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        String rating = request.getParameter("rating");


        if(id == null || id .equals("") ){
            model.addAttribute("title","数据库中没有此论文");
        }
        else{
            try{
                SqlDealer sqlDealer = new SqlDealer();
                Thesis thesis = new Thesis();
                thesis = sqlDealer.searchThesisById(id);
                boolean bought = false;

                if(thesis != null){
                    System.out.println("点击数"+thesis.getClickCount());
                    thesis.clickCount++;
                    if(thesis.getPublishTime()==null){
                        sqlDealer.updateClick1(thesis);

                        String id1,id2,href="";
                        if(user==null){
                            href="/MyTech/to_login";
                            model.addAttribute("type","1");
                        }
                        else{
                            id1 = user.getId();
                            id2 = thesis.getId();
                            boolean judge = false;
                            List<UserBuyThesis> boughtList = sqlDealer.searchUserBuyThesisByUserId(user.getId(),0,99);
                            for(UserBuyThesis temp : boughtList){
                                if(thesis.getId() .equals(temp.getThesisId()) ){
                                    judge = true;
                                    break;
                                }
                            }
                            if(judge){
                                model.addAttribute("type","2");
                                href="http://94.191.112.232:8080/UploadTest/DownloadServlet?id="+thesis.getProfessorId()+"&filename="+thesis.getUrl();
                            }
                            else{
                                model.addAttribute("type","1");
                                href="javascript:purchase(&quot;"+id1+"&quot;,&quot;"+id2+"&quot;);";
                            }
                        }
                        model.addAttribute("href",href);
                        model.addAttribute("hid","");
                        model.addAttribute("score",thesis.getScore());
                    }
                    else{
                        sqlDealer.updateClick2(thesis);
                        model.addAttribute("type","0");
                        model.addAttribute("href",thesis.getUrl());
                        model.addAttribute("hid","hidden");
                    }
                    model.addAttribute("id",thesis.getId());
                    model.addAttribute("title",thesis.getTitle());
                    model.addAttribute("authors",thesis.getAuthor());
                    model.addAttribute("info",thesis.getSummary());
                    model.addAttribute("keywords",thesis.getKeyword());
                    model.addAttribute("url",thesis.getUrl());
                    model.addAttribute("refcount",thesis.getReferenceCount());
                    model.addAttribute("clickcount",thesis.getClickCount());
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
                    thesis.setAverageGrade(grade);
                    System.out.println(grade);
                    if(thesis.getPublishTime()==null)
                        sqlDealer.updateGrade1(thesis);
                    else
                        sqlDealer.updateGrade2(thesis);
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
        try{
            SqlDealer sqlDealer = new SqlDealer();
            com.woxue.mt.sqldealer.User user = sqlDealer.searchUserById(id1);
            int score = user.getScore();
            Thesis temp = sqlDealer.searchThesisById(id2);
            if(score>=temp.getScore()){
                //user.setScore(score-temp.getScore());
                //sqlDealer.updateUser(user);
                return "{\"result\":\"true\",\"price\":\""+temp.getScore()+"\"}";
            }
            else{
                return "{\"result\":\"false\"}";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    @ResponseBody
    @RequestMapping("/confirm")
    public String confirm(HttpServletRequest request ,HttpSession session){
        String id1 = request.getParameter("id1");
        String id2 = request.getParameter("id2");
        User user1 = (User)session.getAttribute("user");

        try{
            SqlDealer sqlDealer = new SqlDealer();
            com.woxue.mt.sqldealer.User user = sqlDealer.searchUserById(id1);
            int score = user.getScore();
            Thesis temp = sqlDealer.searchThesisById(id2);
                user.setScore(score-temp.getScore());
                user1.setCredit(score-temp.getScore());
                session.setAttribute("user",user1);
                sqlDealer.updateUser(user);
                UserBuyThesis buyInfo = new UserBuyThesis();
                buyInfo.setUserId(user.getId());
                buyInfo.setThesisId(temp.getId());
                sqlDealer.insertUserBuyThesis(buyInfo);
                return "http://94.191.112.232:8080/UploadTest/DownloadServlet?id="+temp.getProfessorId()+"&filename="+temp.getUrl();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
