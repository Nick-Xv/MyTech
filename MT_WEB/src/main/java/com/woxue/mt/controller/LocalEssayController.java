package com.woxue.mt.controller;

import com.woxue.mt.dao.LocalEssayDao;
import com.woxue.mt.entity.LocalEssay;
import com.woxue.mt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("localEssayController")
public class LocalEssayController {
    @Autowired
    private LocalEssayDao localEssayDao;

    //前往添加页面
    @RequestMapping("to_add_local_essay")
    public String toAddLocalEssay(Map<String, Object> map) {
        map.put("localEssay", new LocalEssay());
        return "local_essay_add";
    }

    //添加文献
    @RequestMapping("add_local_essay")
    public String addLocalEssay(HttpSession session,LocalEssay localEssay) {
        User user = (User)session.getAttribute("user");
        String link = (String)session.getAttribute("essayLink");
        localEssay.setProfessorId(user.getId());
        localEssay.setLink(link);
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
}
