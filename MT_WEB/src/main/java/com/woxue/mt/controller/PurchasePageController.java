package com.woxue.mt.controller;

import com.woxue.mt.entity.User;
import com.woxue.mt.sqldealer.SqlDealer;
import com.woxue.mt.sqldealer.Thesis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/purchasePage")
public class PurchasePageController {
    @RequestMapping(method = RequestMethod.GET)
    public String printPage(ModelMap model, HttpSession session, User user){
        user = (User)session.getAttribute("user");
        try{
            SqlDealer sqlDealer = new SqlDealer();
            List<Thesis> bought = sqlDealer.searchBoughtThesisById(user.getId());
            for(Thesis t: bought){
                t.setUrl("http://94.191.112.232:8080/UploadTest/DownloadServlet?id="+t.getProfessorId()+"&filename="+t.getUrl());
            }
            model.addAttribute("list",bought);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "purchasePage";
    }
}
