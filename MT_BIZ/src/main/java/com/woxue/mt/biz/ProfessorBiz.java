package com.woxue.mt.biz;

import com.woxue.mt.entity.Professor;

import java.util.List;

public interface ProfessorBiz {
    void add(Professor professor);
    void edit(Professor professor);
    void remove(String id);
    Professor get(String id);
    List<Professor> getAll();
}
