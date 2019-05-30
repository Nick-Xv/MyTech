package com.woxue.mt.dao;

import com.woxue.mt.entity.ProfessorApplication;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProfessorApplicationDao")
public interface ProfessorApplicationDao {
    void insert(ProfessorApplication professorApplication);
    void update(ProfessorApplication professorApplication);
    void delete(int id);
    ProfessorApplication select(int id);
    ProfessorApplication selectByUserId(String userId);
    List<ProfessorApplication> selectAll();
    List<ProfessorApplication> selectToBeDeal();
}
