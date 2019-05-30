package com.woxue.mt.dao;

import com.woxue.mt.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AdminDao")
public interface AdminDao {
    void insert(Admin admin);
    void update(Admin admin);
    void delete(String id);
    Admin select(String id);
    List<Admin> selectAll();
}
