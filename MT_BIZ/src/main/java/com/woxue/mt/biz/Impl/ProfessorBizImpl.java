package com.woxue.mt.biz.Impl;

import com.woxue.mt.biz.ProfessorBiz;
import com.woxue.mt.dao.ProfessorDao;
import com.woxue.mt.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorBizImpl implements ProfessorBiz {
    @Autowired
    private ProfessorDao professorDao;

    public void add(Professor professor) {
        professorDao.insert(professor);
    }

    public void edit(Professor professor) {
        professorDao.update(professor);
    }

    public void remove(String id) {
        professorDao.delete(id);
    }

    public Professor get(String id) {
        return professorDao.select(id);
    }

    public List<Professor> getAll() {
        return professorDao.selectAll();
    }
}
