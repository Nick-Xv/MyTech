package com.woxue.mt.dao;

import com.woxue.mt.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("UserDao")
public interface UserDao {
    void insert(User user);
    void update(User user);
    void delete(String id);
    User select(String id);
    List<User> selectAll();
}
