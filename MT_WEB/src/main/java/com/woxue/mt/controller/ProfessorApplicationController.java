package com.woxue.mt.controller;

import com.woxue.mt.biz.ProfessorApplicationBiz;
import com.woxue.mt.biz.ProfessorBiz;
import com.woxue.mt.dao.DealRecordAPDao;
import com.woxue.mt.dao.ProfessorApplicationDao;
import com.woxue.mt.entity.DealRecordAP;
import com.woxue.mt.entity.Professor;
import com.woxue.mt.entity.ProfessorApplication;
import com.woxue.mt.entity.User;
import com.woxue.mt.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/*
* 专家申请——控制器
* */
@Controller("ProfessorApplicationController")
public class ProfessorApplicationController {
    @Autowired
    private ProfessorApplicationBiz professorApplicationBiz;
    @Autowired
    private ProfessorApplicationDao professorApplicationDao;
    @Autowired
    private DealRecordAPDao dealRecordAPDao;
    @Autowired
    private ProfessorBiz professorBiz;

    //列表：显示所有未经处理的申请
    @RequestMapping("/to_application_list")
    public String toApplicationList(Map<String,Object> map) {
        map.put("applications",professorApplicationDao.selectToBeDeal());
        return "professor_application_list";
    }

    //条件跳转：当普通用户没有提交申请的时候跳转到申请填写页面，已填写过申请的跳转到申请详情页
    @RequestMapping("/to_add_application")
    public String toAdd(HttpSession session,Map<String,Object> map) {
        User user = (User) session.getAttribute("user");
        ProfessorApplication application = professorApplicationBiz.getByUserId(user.getId());
        //已填写过申请的跳转到申请详情页
        if(application != null) {
            return "redirect:application_detail?id="+application.getId();
        }
        //没有提交申请的时候跳转到申请填写页面
        map.put("application",new ProfessorApplication());
        return "professor_application_add";
    }

    //添加新申请
    @RequestMapping("/add_application")
    public String add(HttpSession session, ProfessorApplication application){
        User user = (User) session.getAttribute("user");
        String userId = user.getId();
        application.setUserId(userId);
        professorApplicationBiz.save(application);
        //把新的申请读出来，因为不知道id
        ProfessorApplication application1 = professorApplicationBiz.getByUserId(userId);
        //写一条记录
        DealRecordAP dealRecordAP = new DealRecordAP();
        dealRecordAP.setApId(application1.getId());
        dealRecordAP.setAdminId(user.getName());
        dealRecordAP.setDealTime(new Date());
        dealRecordAP.setDealMethod(Constant.APPLICATION_CREATED);
        dealRecordAPDao.insert(dealRecordAP);
        return "redirect:application_detail?id="+application.getId();
    }

    //去修改申请
    @RequestMapping("/to_update_application")
    public String toUpdate(HttpSession session, Map<String,Object> map) {
        User user = (User) session.getAttribute("user");
        ProfessorApplication application = professorApplicationBiz.getByUserId(user.getId());
        map.put("application",application);
        return "professor_application_update";
    }

    //修改申请
    @RequestMapping("/update_application")
    public String update(HttpSession session, ProfessorApplication application) {
        User user = (User) session.getAttribute("user");
        application.setState(Constant.APPLICATION_CHANGED);
        professorApplicationBiz.update(application);
        //写一条记录
        DealRecordAP dealRecordAP = new DealRecordAP();
        dealRecordAP.setApId(application.getId());
        dealRecordAP.setAdminId(user.getName());
        dealRecordAP.setDealTime(new Date());
        dealRecordAP.setDealMethod(Constant.APPLICATION_CHANGED);
        dealRecordAPDao.insert(dealRecordAP);
        return "redirect:application_detail?id="+application.getId();
    }


    //查看申请详情
    @RequestMapping("/application_detail")
    public String detail(int id, Map<String,Object> map){
        map.put("application",professorApplicationBiz.get(id));
        map.put("records",professorApplicationBiz.getRecords(id));
        return "professor_application_detail";
    }

    //删除申请（只能由管理员调用）
    @RequestMapping("/application_remove")
    public String remove(int id){
        professorApplicationDao.delete(id);
        return "redirect:to_application_list";
    }

    //驳回申请
    @RequestMapping(value = "/application_deny",params = "id")
    public String deny(HttpSession session,int id, @RequestParam String note){
        ProfessorApplication application = professorApplicationBiz.get(id);
        User user = (User) session.getAttribute("user");
        application.setState(Constant.APPLICATION_DENIED);
        professorApplicationBiz.update(application);
        //写一条记录
        DealRecordAP dealRecordAP = new DealRecordAP();
        dealRecordAP.setApId(application.getId());
        dealRecordAP.setAdminId(user.getName());
        dealRecordAP.setDealTime(new Date());
        dealRecordAP.setDealMethod(Constant.APPLICATION_DENIED);
        dealRecordAP.setNotes(note);
        dealRecordAPDao.insert(dealRecordAP);
        return "redirect:application_detail?id="+application.getId();
    }

    //通过申请
    @RequestMapping(value = "/application_accept",params = "id")
    public String accept(HttpSession session,int id){
        User user = (User) session.getAttribute("user");
        ProfessorApplication application = professorApplicationBiz.get(id);
        application.setState(Constant.APPLICATION_ACCEPTED);
        professorApplicationBiz.update(application);
        //写一条记录
        DealRecordAP dealRecordAP = new DealRecordAP();
        dealRecordAP.setApId(application.getId());
        dealRecordAP.setAdminId(user.getName());
        dealRecordAP.setDealTime(new Date());
        dealRecordAP.setDealMethod(Constant.APPLICATION_ACCEPTED);
        dealRecordAPDao.insert(dealRecordAP);
        return "redirect:application_detail?id="+application.getId();
    }

    //成为专家
    @RequestMapping(value = "become_professor",params = "id")
    public String becomeProfessor(HttpSession session,int id){
        User user = (User) session.getAttribute("user");
        ProfessorApplication application = professorApplicationBiz.get(id);
        Professor professor = new Professor();
        professor.setBirthday(application.getBirthday());
        professor.setId(application.getUserId());
        professor.setIntroduction(application.getIntroduction());
        professor.setName(application.getName());
        professor.setOrganization(application.getOrganization());
        professor.setPost(application.getPost());
        professorBiz.add(professor);
        user.setCharacter(Constant.CHAR_EXPERT);
        session.setAttribute("user",user);
        return "self";
    }
}
