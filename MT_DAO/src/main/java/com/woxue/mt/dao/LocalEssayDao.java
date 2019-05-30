package com.woxue.mt.dao;

import com.woxue.mt.entity.LocalEssay;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 针对本站论文表进行持久化操作的接口
* */
@Repository("LocalEssayDao")
public interface LocalEssayDao {
    void insert(LocalEssay localEssay);
    void update(LocalEssay localEssay);
    void delete(int id);
    LocalEssay select(int id);
    List<LocalEssay> selectAll();
    List<LocalEssay> selectByProfessorId(int professorId);//找出某专家名下的所有论文
    List<LocalEssay> selectByKeyword(List<String> keywords);//找出包含某关键字的所有论文
}
