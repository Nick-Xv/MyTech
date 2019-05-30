package com.woxue.mt.biz;

import com.woxue.mt.entity.Admin;

import java.util.List;

public interface AdminBiz {
    void add(Admin admin);
    void edit(Admin admin);
    void remove(String id);
    Admin get(String id);
    List<Admin> getAll();
}
