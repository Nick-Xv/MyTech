package com.woxue.mt.biz.Impl;

import com.woxue.mt.biz.UserBiz;
import com.woxue.mt.dao.UserDao;
import com.woxue.mt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserDao userDao;

    public void add(User user) {
        userDao.insert(user);
    }

    public void edit(User user) {
        userDao.update(user);
    }

    public void remove(String id) {
        userDao.delete(id);
    }

    public User get(String id) {
        return userDao.select(id);
    }

    public List<User> getAll() {
        return userDao.selectAll();
    }
}
