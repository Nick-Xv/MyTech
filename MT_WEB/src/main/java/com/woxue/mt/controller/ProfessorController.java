package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
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
        model.addAttribute("id1","a123");
        model.addAttribute("id2","a-321");

        model.addAttribute("url","/MyTech/professor_essay");
        model.addAttribute("url1","/MyTech/professor_moment");

        String id = request.getParameter("id");
        if(id == null || id == ""){
            model.addAttribute("title","数据库中没有此专家");
        }
        else{
            try{
                SqlDealer sqlDealer = new SqlDealer();
                Professor professor = new Professor();
                professor = sqlDealer.searchProfessorById(id);
                List<ProfessorOwnThesis> potList = sqlDealer.searchProfessorOwnThesisByProfessorId(id,0,20);
                Relationship relList = sqlDealer.searchRelationshipByProfessorId(id);
                List<RelationshipDiv> proflist = new ArrayList<>();
                if(relList != null){
                    String names = relList.getSlaveProfessorName();
                    String urls = relList.getSlaveProfessorUrl();
                    String[] name = names.split(",");
                    String[] url = urls.split(",");
                    for(int i=0;i<url.length&&i<6;i++){
                        RelationshipDiv temp = new RelationshipDiv();
                        temp.setName(name[i]);
                        temp.setUrl("http://xueshu.baidu.com"+url[i]);
                        proflist.add(temp);
                    }
                    model.addAttribute("profList",proflist);
                }
                if(professor != null){
                    if(professor.getBirthday()==null){
                        model.addAttribute("p1","hidden");
                        model.addAttribute("p2","");
                        model.addAttribute("momenthid","hidden");
                    }
                    else{
                        model.addAttribute("p1","");
                        model.addAttribute("p2","hidden");
                        model.addAttribute("momenthid","");
                    }

                    model.addAttribute("name",professor.getName());
                    model.addAttribute("ins",professor.getOrganization());
                    model.addAttribute("prof",professor.getTitle());
                    model.addAttribute("birth",professor.getBirthday());
                    model.addAttribute("area",professor.getArea());
                    model.addAttribute("info",professor.getSummary());
                    if(professor.getArea()!=null)
                        model.addAttribute("data","被引频次："+professor.getReferenceCount()+"   成果数："+professor.getWorkNumber());
                }
                List<Thesis> potThesisList = new ArrayList<Thesis>();
                Thesis tempT = new Thesis();
                if(potList.size()!=0){
                    int i=0;
                    for(ProfessorOwnThesis temp : potList){
                        System.out.println(temp.getThesisId());
                        tempT = sqlDealer.searchThesisById(temp.getThesisId());
                        if(tempT != null){
                            potThesisList.add(tempT);
                            i++;
                        }
                        if(i>=10)break;
                    }
                    model.addAttribute("productList",potThesisList);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "professor";
    }

    @ResponseBody
    @RequestMapping("/watch")
    public String watch(HttpServletRequest request, ModelMap model){
        return "true";
    }
}
