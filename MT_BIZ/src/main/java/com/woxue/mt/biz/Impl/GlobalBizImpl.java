package com.woxue.mt.biz.Impl;

import com.woxue.mt.biz.GlobalBiz;
import com.woxue.mt.dao.UserDao;
import com.woxue.mt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {
    @Autowired
    UserDao userDao;

    public User login(String id, String password) {
        User user = userDao.select(id);
        //当用户存在 且 密码正确时，登录成功
        if(user != null && user.getPassword().equals(password)) {
            return user;
        }
        //空返回即为失败
        return null;
    }

    public void changePassword(User user) {
        //表现层已经完成了修改，只需要更新一下即可
        userDao.update(user);
    }
}
