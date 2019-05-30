package com.woxue.mt.controller;

import com.woxue.mt.biz.UserBiz;
import com.woxue.mt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("userController")
//@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBiz userBiz;

    //获得所有用户列表
    @RequestMapping("/user_list")
    public String list(Map<String,Object> map) {
        map.put("list",userBiz.getAll());
        return "user_list";
    }

    //打开添加用户界面
    @RequestMapping("/user_to_add")
    public String toAdd(Map<String,Object> map) {
        map.put("user",new User());
        return "user_add";
    }

    //添加用户
    @RequestMapping("/user_add")
    public String add(User user) {
        userBiz.add(user);
        return "redirect:user_list";//不能直接返回页面，而是通过控制器，不然数据加载就被跳过了
    }

    //修改用户信息（管理员调用）
    @RequestMapping(value = "/user_to_update",params = "id")
    public String toUpdate(String id,Map<String,Object> map) {
        map.put("user",userBiz.get(id));
        return "user_update";
    }
    @RequestMapping("/user_update")
    public String update(User user){
        userBiz.edit(user);
        return "redirect:user_list";
    }

    //修改用户信息（用户自己调用）
    @RequestMapping(value = "/user_to_update_by_user",params = "id")
    public String toUpdateByUser(String id,Map<String,Object> map) {
        map.put("user",userBiz.get(id));
        return "user_update_by_user";
    }
    @RequestMapping("/user_update_by_user")
    public String updateByUser(HttpSession session,User user){
        userBiz.edit(user);
        //先保存一下身份信息，在更新session前进行写回防止丢失
        User userOld = (User)session.getAttribute("user");
        user.setCharacter(userOld.getCharacter());
        session.setAttribute("user",user);
        return "redirect:self";
    }

    //删除用户
    @RequestMapping(value = "/user_remove",params = "id")
    public String Remove(String id){
        userBiz.remove(id);
        return "redirect:user_list";
    }
}
