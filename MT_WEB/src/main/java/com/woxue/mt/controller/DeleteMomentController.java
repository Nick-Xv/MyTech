package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.SqlDealer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/delete_moment")
public class DeleteMomentController {
    @RequestMapping(method = RequestMethod.GET)
    public String deleteMoment(HttpServletRequest request, ModelMap model, HttpSession session, User user)throws Exception{
        String tid = request.getParameter("tid");
        if(tid != null)
            try{
                SqlDealer sqlDealer = new SqlDealer();
                sqlDealer.deleteTrendById(tid);
                return "redirect:user_my_moment";
            }catch (Exception e){
                e.printStackTrace();
            }
        return "redirect:user_my_moment";
    }
}
