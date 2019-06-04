package com.woxue.mt.controller;

import com.woxue.mt.dao.LocalEssayDao;
import com.woxue.mt.entity.LocalEssay;
import com.woxue.mt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("localEssayController")
public class LocalEssayController {
    @Autowired
    private LocalEssayDao localEssayDao;

    //前往添加页面
    @RequestMapping("to_add_local_essay")
    public String toAddLocalEssay(Map<String, Object> map, HttpSession session, ModelMap model) {
        map.put("localEssay", new LocalEssay());
        User user = (User)session.getAttribute("user");
        if(user!=null){
            model.addAttribute("id",user.getId());
        }
        return "local_essay_add";
    }

    //添加文献
    @RequestMapping("add_local_essay")
    public String addLocalEssay(HttpSession session,LocalEssay localEssay) {
        User user = (User)session.getAttribute("user");
        localEssay.setProfessorId(user.getId());
        localEssayDao.insert(localEssay);
        return "redirect:local_essay_list";
    }

    //获得所有文献列表
    @RequestMapping("/local_essay_list")
    public String list(HttpSession session,Map<String, Object> map) {
        User user = (User)session.getAttribute("user");
        map.put("list",localEssayDao.selectByProfessorId(user.getId()));
        return "local_essay_list";
    }

    //删除文献
    @RequestMapping(value = "/local_essay_remove",params = "id")
    public String Remove(int id){
        localEssayDao.delete(id);
        return "redirect:local_essay_list";
    }

    //修改用户信息（用户自己调用）
    @RequestMapping(value = "/local_essay_to_update",params = "id")
    public String toUpdateByUser(int id,Map<String,Object> map) {
        map.put("localEssay",localEssayDao.select(id));
        localEssayDao.update(localEssayDao.select(id));
        return "local_essay_update";
    }
    @RequestMapping("/local_essay_update")
    public String updateByUser(HttpSession session,LocalEssay localEssay){
        localEssayDao.update(localEssay);
        //先保存一下身份信息，在更新session前进行写回防止丢失
        return "redirect:local_essay_list";
    }
}
