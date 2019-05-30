package com.woxue.mt.biz;

import com.woxue.mt.entity.User;

public interface GlobalBiz {
    //登录
    User login(String id,String password);
    //退出是对Session的操作，放置在表现层，这里不用
    //修改密码
    void changePassword(User user);
}
