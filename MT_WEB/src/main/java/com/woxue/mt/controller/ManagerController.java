package com.woxue.mt.controller;

import com.woxue.mt.sqldealer.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
//@RequestMapping("/background")
public class ManagerController {

    private static SqlDealer sqlDealer = null;

    static {
        try {
            sqlDealer =  new SqlDealer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/overview")
    public String overview(Model model){
        //长度 30
        //labels表示日期
        String labels = overviewTool(5,30);
        String userData = overviewTool(8,30);
        String professorData = overviewTool(11,44);
        String scienceData = overviewTool(2,29);
        model.addAttribute("labels", labels);
        model.addAttribute("userData", userData);
        model.addAttribute("professorData", professorData);
        model.addAttribute("scienceData", scienceData);
        return "overview";
    }

    @RequestMapping("/user")
    public  String userManage(){
        return "userManage";
    }
//,method = RequestMethod.POST
    @RequestMapping("/professor_list")
    @ResponseBody
    public JSONArray professorList(Model model){
        List<Professor> profList = sqlDealer.searchProfessor(0,20);
        net.sf.json.JSONArray profList_json = net.sf.json.JSONArray.fromObject(profList);
        //model.addAttribute("profList", profList_json);
        System.out.println(profList_json);
        return profList_json;
    }

    @RequestMapping("/professorManage")
    public  String professorManage(Model model){
        List<Professor> profList = sqlDealer.searchProfessor(0,50);
        net.sf.json.JSONArray profList_json = net.sf.json.JSONArray.fromObject(profList);
        model.addAttribute("profList", profList_json);
        return "professorManage";
    }


    @RequestMapping("/scienceManage")
    public  String scienceManage(Model model){
        List<String> key = new ArrayList<>();
        SqlDealer.Order order = SqlDealer.Order.DEFAULT;
        List<Thesis> sciList= sqlDealer.searchThesisAnd(key,"0000",order,0,100);
        model.addAttribute("sciList", sciList);
        return "scienceManage";
    }


    /**
     * 查看并审核已经上传的科技专家
     * public String id;
     * public String name;
     * public String organization;
     * public String area;
     * public int referenceCount;
     * public int workNumber;
     * public int verifyState;
     */
    @RequestMapping("/viewProfessor")
    public String viewProfessor(Model model) {
        List<Professor> profList = sqlDealer.searchProfessor(0,10);
        model.addAttribute("profList", profList);
        return "professorManage";
    }

    @RequestMapping("/viewUncheckedProfessor")
    public String viewUncheckedProfessor(Model model) {
        List<Professor> uncheckedProfList = sqlDealer.searchProfessorUnverified(0,20);
        net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(uncheckedProfList);
        model.addAttribute("profList", json);
        return "professorManage";
    }

    @RequestMapping("/admitProfessor")
    public String admitProfessor(@RequestParam(value = "id") String id, Model model) {
        Professor prof = new Professor();
        prof.id = id;
        prof.verifyState = 1;
        sqlDealer.updateProfessor(prof);
        return viewUncheckedProfessor(model); // 每次更新返回unchecked页面
    }

    /**
     * 查看并审核已经上传的科技成果
     * public String title;
     * public String author;
     * public int referenceCount;
     * public Date publishTime;
     * public String keyword;
     * public String summary;
     * public String id;
     * public String url;
     * public int verifyState;
     */
//    @RequestMapping("/viewScience")
//    public String viewScience(Model model) {
//        List<Thesis> sciList= sqlDealer.searchThesisAnd(null, 0,0);
//        model.addAttribute("sciList", sciList);
//        return "scienceManage";
//    }

    @RequestMapping("/viewUncheckedScience")
    public String viewUncheckedScience(Model model) {
        List<Thesis> uncheckedSciList = sqlDealer.searchThesisUnverified(0,100);
        model.addAttribute("sciList", uncheckedSciList);
        return "scienceManage";
    }

    @RequestMapping("/admitScience")
    public String admitScience(@RequestParam(value = "id") String id, Model model) {
        Thesis thesis = new Thesis();
        thesis.id = id;
        thesis.verifyState = 1;
        sqlDealer.updateThesis(thesis);
        return viewUncheckedScience(model);
    }

    /**
     * public String id;
     * public String focusArea;
     * public String nickname;
     * public String password;
     * public String phoneNumber;
     * public String email;
     * public int score;
     */
    @RequestMapping("/viewUser")
    public String viewUser(Model model) {
        List<User> userList = sqlDealer.searchUser(0, 100);
        model.addAttribute("userList", userList);
        return "userManage";
    }

    @RequestMapping("/changeUser")
    public String changeUser(@RequestParam(value = "id") String id,
            @RequestParam(value = "focusArea") String focusArea,
            @RequestParam(value = "nickname") String nickname,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "phoneNumber") String phoneNumber,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "score") int score,
            Model model) {

        User user = new User();
        user.id = id;
        user.focusArea = focusArea;
        user.nickname = nickname;
        user.password = password;
        user.phoneNumber = phoneNumber;
        user.email = email;
        user.score = score;
        sqlDealer.updateUser(user);
        return viewUser(model);
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id") String id, Model model) {
        sqlDealer.deleteUserById(id);
        return viewUser(model);
    }

    /** 用户购买积分 */
    @RequestMapping("/buyScore")
    public String buyScore(@RequestParam(value = "id") String id,
                           @RequestParam(value = "id") int score,
                           Model model) {

        User user = new User();
        sqlDealer.searchUserById(id,0,10);
        user.id = id;
        user.score += score;
        return "overview"; // TODO:
    }

    /** 推送已关注专家动态 */
    @RequestMapping("/recommendProf")
    public String recommendProf(@RequestParam(value = "id") String id, Model model) {

        User user = sqlDealer.searchUserById(id,0,10);
        String focusArea = user.focusArea;
        String[] areas = focusArea.split(","); // 所有关注领域
        List<Professor> profList = new ArrayList<Professor>(); // 所有关注领域的相关专家
        for (String area : areas) {
            List<Professor> profs = sqlDealer.searchProfessorByArea(area,0,10);
            profList.addAll(profs);
        }

        List<Trend> trendList = new ArrayList<Trend>();  // 所有可能感兴趣的专家的动态
        for (Professor prof : profList){
            String profID = prof.id;
            List<Trend> trends = sqlDealer.searchTrendByProfessorId(profID,0,10);
            trendList.addAll(trends);
        }

        model.addAttribute("trendList", trendList);
        return "overview"; // TODO:
    }

    private static String overviewTool(int lowerBound, int upperBound){
        String s = "[";
        int range = upperBound -lowerBound;
        for(int i = 0; i < 30; i++) {
            long ll = System.currentTimeMillis();
            int random = (int)( ll % range );
            random += lowerBound;
            s += random;
            if(i != 29){
                s += ",";
            }
        }
        s+="]";
        return s;
    }
}