package com.woxue.mt.dao;

import com.woxue.mt.entity.Professor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProfessorDao")
public interface ProfessorDao {
    void insert(Professor professor);
    void update(Professor professor);
    void delete(String id);
    Professor select(String id);
    List<Professor> selectAll();
}
