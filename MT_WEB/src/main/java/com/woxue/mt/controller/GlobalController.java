package com.woxue.mt.controller;

import com.woxue.mt.biz.AdminBiz;
import com.woxue.mt.biz.GlobalBiz;
import com.woxue.mt.biz.ProfessorBiz;
import com.woxue.mt.biz.UserBiz;
import com.woxue.mt.entity.User;
import com.woxue.mt.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("globalController")
public class GlobalController implements java.io.Serializable{
    @Autowired
    private GlobalBiz globalBiz;
    @Autowired
    private ProfessorBiz professorBiz;
    @Autowired
    private AdminBiz adminBiz;
    @Autowired
    private UserBiz userBiz;

    //前往充值页面
    @RequestMapping("/to_charge")
    public String toCharge(){
        return "charge";
    }

    //充值
    @RequestMapping("/charge")
    public String charge(HttpSession session,@RequestParam int credit){
        User user = (User) session.getAttribute("user");
        user.setCredit(user.getCredit() + credit);
        userBiz.edit(user);
        return "self";
    }

    //前往注册页面
    @RequestMapping("/to_register")
    public String toRegister(){
        return "register";
    }

    //注册
    @RequestMapping("/register")
    public String add(Map<String,Object> map, @RequestParam String id,
                      @RequestParam String password1 ,@RequestParam String password2,@RequestParam String nickName) {
        //用户名已被注册
        if(userBiz.get(id) != null) {
            map.put("error_message","该用户名已被注册");
            return "register";
        }
        //用户名不能为空
        if(id.equals("")) {
            map.put("error_message","用户名不能为空");
            return "register";
        }
        //昵称不能为空
        if(nickName.equals("")) {
            map.put("error_message","昵称不能为空");
            return "register";
        }
        //密码不能为空
        if(password1.equals("") || password1.equals("")) {
            map.put("error_message","密码不能为空");
            return "register";
        }
        //密码输入不一致
        if(password1.equals(password2) == false) {
            map.put("error_message","两次密码输入不一致");
            return "register";
        }
        //合法
        User user = new User();
        user.setId(id);
        user.setPassword(password1);
        user.setName(nickName);
        userBiz.add(user);
        map.put("success_message","注册成功请登录");
        return "login";
    }

    //前往登录界面
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    //登录动作
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String id, @RequestParam String password){
        User user = globalBiz.login(id,password);
        if (user == null) {
            return "redirect:to_login";
        }
        System.out.println("UserID:"+id);
        //先尝试把判断用户是普通用户、专家用户还是管理员的逻辑放到这里
        if(adminBiz.get(id) != null) {
            user.setCharacter(Constant.CHAR_ADMIN);
            System.out.println("UserCharacter:Admin");
        }
        else if(professorBiz.get(id) != null) {
            user.setCharacter(Constant.CHAR_EXPERT);
            session.setAttribute("professor",professorBiz.get(id));
        }
        else {
            user.setCharacter(Constant.CHAR_USER);
        }
        session.setAttribute("user",user);
        return "redirect:self";
    }

    //登陆成功跳转到个人信息页面
    @RequestMapping("/self")
    public String self(){
        return  "self";
    }

    //退出：将session中的user置空即可，重定向回登录页
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("user",null);
        return "redirect:to_login";
    }

    //前往更改密码
    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    //修改密码
    //
    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1 ,@RequestParam String new2){
        User user = (User) session.getAttribute("user");
        //旧密码输入正确 且 新密码两次输入相同，进行密码重置
        if(user.getPassword().equals(old)){
            if(new1.equals(new2)){
                user.setPassword(new1);
                globalBiz.changePassword(user);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password";
    }
}
