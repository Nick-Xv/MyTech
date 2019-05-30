package com.woxue.mt.biz.Impl;

import com.woxue.mt.biz.AdminBiz;
import com.woxue.mt.dao.AdminDao;
import com.woxue.mt.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBizImpl implements AdminBiz {
    @Autowired
    private AdminDao adminDao;

    public void add(Admin admin) {
        adminDao.insert(admin);
    }

    public void edit(Admin admin) {
        adminDao.update(admin);
    }

    public void remove(String id) {
        adminDao.delete(id);
    }

    public Admin get(String id) {
        return adminDao.select(id);
    }

    public List<Admin> getAll() {
        return adminDao.selectAll();
    }
}
