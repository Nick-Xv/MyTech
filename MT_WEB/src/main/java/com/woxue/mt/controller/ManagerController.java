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

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


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
        String labels = overviewTime();
        String userData = overviewTool(8,30);
        String professorData = overviewTool(11,44);
        String scienceData = overviewTool(2,29);
        System.out.println(labels);
        System.out.println(userData);
        System.out.println(professorData);
        System.out.println(scienceData);
        net.sf.json.JSONArray labels_json = net.sf.json.JSONArray.fromObject(labels);
        model.addAttribute("labels", labels_json);
        model.addAttribute("userData", userData);
        model.addAttribute("professorData", professorData);
        model.addAttribute("scienceData", scienceData);
        return "overview";
    }

    @RequestMapping("/user")
    public  String userManage(){
        return "userManage";
    }

//    @RequestMapping("/professor_list")
//    @ResponseBody
//    public JSONArray professorList(Model model){
//        List<Professor> profList = sqlDealer.searchProfessor(0,20);
//        net.sf.json.JSONArray profList_json = net.sf.json.JSONArray.fromObject(profList);
//        //model.addAttribute("profList", profList_json);
//        System.out.println(profList_json);
//        return profList_json;
//    }


//    @RequestMapping("/science_list")
//    public  String scienceManage(Model model) {
//        SqlDealer.Order order = SqlDealer.Order.DEFAULT;
//        List<Thesis> sciList= sqlDealer.searchThesis(null, "0000", order,0,100);
//        model.addAttribute("sciList", sciList);
//        return "scienceManage";
//    }


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
    @RequestMapping("/professorManage")
    public  String professorManage(Model model){
        List<Professor> profList = sqlDealer.searchProfessor(null, 0,100);
        net.sf.json.JSONArray profList_json = net.sf.json.JSONArray.fromObject(profList);
        model.addAttribute("profList", profList_json);
        return "professorManage";
    }

    @RequestMapping("/professorSearch")
    public  String professorSearch(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String organization = request.getParameter("organization");
        String area = request.getParameter("area");
        List<String> nameList = string2List(name);
        List<String> orgList = string2List(organization);
        List<String> areaList = string2List(area);

        List<Professor> profList = sqlDealer.advancedSearchProfessor(nameList, orgList, areaList, 0, 100);
        net.sf.json.JSONArray profList_json = net.sf.json.JSONArray.fromObject(profList);
        model.addAttribute("profList", profList_json);
        return "professorManage";
    }

    @RequestMapping("/professorDelete")
    public String professorDelete(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        sqlDealer.deleteProfessorById(id);
        return professorManage(model); // 更新页面
    }

    @RequestMapping("/professorChange")
    public String professorChange(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String organization = request.getParameter("organization");
        String area = request.getParameter("area");
        int referenceCount = Integer.parseInt(request.getParameter("referenceCount"));
        int workNumber = Integer.parseInt(request.getParameter("workNumber"));
        int verifyState = Integer.parseInt(request.getParameter("workNumber"));

        Professor prof = new Professor();
        prof.id = id;
        prof.name = name;
        prof.organization = organization;
        prof.area = area;
        prof.referenceCount = referenceCount;
        prof.workNumber = workNumber;
        prof.verifyState = verifyState;
        sqlDealer.updateProfessor(prof);
        return professorManage(model);
    }

//    @RequestMapping("/viewUncheckedProfessor")
//    public String viewUncheckedProfessor(Model model) {
//        List<Professor> uncheckedProfList = sqlDealer.searchProfessorUnverified(0,100);
//        model.addAttribute("profList", uncheckedProfList);
//        return "professorManage";
//    }

//    @RequestMapping("/admitProfessor")
//    public String admitProfessor(@RequestParam(value = "id") String id, Model model) {
//        Professor prof = new Professor();
//        prof.id = id;
//        prof.verifyState = 1;
//        sqlDealer.updateProfessor(prof);
//        return viewUncheckedProfessor(model); // 每次更新返回unchecked页面
//    }

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
    @RequestMapping("/scienceManage")
    public String scienceManage(Model model) {
        List<Thesis> sciList= sqlDealer.searchThesis(null, "0000", SqlDealer.Order.DEFAULT, 0, 100);
        net.sf.json.JSONArray sciList_json = net.sf.json.JSONArray.fromObject(sciList);
        model.addAttribute("sciList", sciList_json);
        return "scienceManage";
    }

    @RequestMapping("/scienceSearch")
    public  String scienceSearch(HttpServletRequest request, Model model){
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String keyword = request.getParameter("keyword");
        List<String> titleList = string2List(title);
        List<String> authorList = string2List(author);
        List<String> keywordList = string2List(keyword);

        SqlDealer.Order order = SqlDealer.Order.DEFAULT;
        List<Thesis> sciList = sqlDealer.advancedSearchThesis(titleList, authorList, keywordList,
                "0000", "9999", order, 0, 100);
        net.sf.json.JSONArray sciList_json = net.sf.json.JSONArray.fromObject(sciList);
        model.addAttribute("sciList", sciList_json);
        return "scienceManage";
    }

    @RequestMapping("/scienceDelete")
    public String scienceDelete(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        sqlDealer.deleteScienceById(id);
        return scienceManage(model); // 更新页面
    }

    @RequestMapping("/scienceChange")
    public String scienceChange(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publishTime = request.getParameter("publishTime");
        String keyword = request.getParameter("keyword");
        String summary = request.getParameter("summary");
        String url = request.getParameter("url");
        int referenceCount = Integer.parseInt(request.getParameter("referenceCount"));
        int verifyState = Integer.parseInt(request.getParameter("workNumber"));

        Thesis thesis = new Thesis();
        thesis.id = id;
        thesis.title = title;
        thesis.author = author;
        thesis.publishTime = publishTime;
        thesis.keyword = keyword;
        thesis.summary = summary;
        thesis.url = url;
        thesis.referenceCount = referenceCount;
        thesis.verifyState = verifyState;
        sqlDealer.updateThesis(thesis);
        return scienceManage(model);
    }

//    @RequestMapping("/viewUncheckedScience")
//    public String viewUncheckedScience(Model model) {
//        List<Thesis> uncheckedSciList = sqlDealer.searchThesisUnverified(0,100);
//        model.addAttribute("sciList", uncheckedSciList);
//        return "scienceManage";
//    }

//    @RequestMapping("/admitScience")
//    public String admitScience(@RequestParam(value = "id") String id, Model model) {
//        Thesis thesis = new Thesis();
//        thesis.id = id;
//        thesis.verifyState = 1;
//        sqlDealer.updateThesis(thesis);
//        return viewUncheckedScience(model);
//    }

    /**
     * public String id;
     * public String focusArea;
     * public String nickname;
     * public String password;
     * public String phoneNumber;
     * public String email;
     * public int score;
     */
//    @RequestMapping("/viewUser")
//    public String viewUser(Model model) {
//        List<User> userList = sqlDealer.searchUser(0, 100);
//        model.addAttribute("userList", userList);
//        return "userManage";
//    }
//
//    @RequestMapping("/changeUser")
//    public String changeUser(@RequestParam(value = "id") String id,
//            @RequestParam(value = "focusArea") String focusArea,
//            @RequestParam(value = "nickname") String nickname,
//            @RequestParam(value = "password") String password,
//            @RequestParam(value = "phoneNumber") String phoneNumber,
//            @RequestParam(value = "email") String email,
//            @RequestParam(value = "score") int score,
//            Model model) {
//
//        User user = new User();
//        user.id = id;
//        user.focusArea = focusArea;
//        user.nickname = nickname;
//        user.password = password;
//        user.phoneNumber = phoneNumber;
//        user.email = email;
//        user.score = score;
//        sqlDealer.updateUser(user);
//        return viewUser(model);
//    }
//
//    @RequestMapping("/deleteUser")
//    public String deleteUser(@RequestParam(value = "id") String id, Model model) {
//        sqlDealer.deleteUserById(id);
//        return viewUser(model);
//    }

    /** 用户购买积分 */
    @RequestMapping("/buyScore")
    public String buyScore(@RequestParam(value = "id") String id,
                           @RequestParam(value = "id") int score,
                           Model model) {

        User user = new User();
        sqlDealer.searchUserById(id);
        user.id = id;
        user.score += score;
        return "overview"; // TODO:
    }

    /** 推送已关注专家动态 */
    @RequestMapping("/recommendProf")
    public String recommendProf(@RequestParam(value = "id") String id, Model model) {

        User user = sqlDealer.searchUserById(id);
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

    private static String overviewTime(){
        String s = "[";
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        for(int i = -29; i<=0; i++){
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,i); // 向前多少天
            String date= sdf.format(calendar.getTime());
            s += date;
            if(i != 0){
                s += ",";
            }
        }
        s+="]";
        return s;
    }

    private static String overviewTool(int lowerBound, int upperBound){
        String s = "[";
        int range = upperBound -lowerBound;
        for(int i = 0; i < 30; i++) {
            Random ra = new Random();
            int random = ra.nextInt(range);
            random += lowerBound;
            s += random;
            if(i != 29){
                s += ",";
            }
        }
        s+="]";
        return s;
    }

    // "zzx pyq 123" -> ["zzx", "pyq", "123"]
    private static List<String> string2List(String s){
        List<String> list;
        if(!s.equals("")) {
            String[] strings = s.split(" "); // 所有关注领域\
            list = Arrays.asList(strings);
        }else{
            list = null;
        }
        return list;
    }
}