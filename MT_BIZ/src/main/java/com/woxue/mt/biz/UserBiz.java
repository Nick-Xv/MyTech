package com.woxue.mt.biz;

import com.woxue.mt.entity.User;

import java.util.List;

public interface UserBiz {
    void add(User user);
    void edit(User user);
    void remove(String id);
    User get(String id);
    List<User> getAll();
}
