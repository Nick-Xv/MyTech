package com.woxue.mt.biz;

import com.woxue.mt.entity.DealRecordAP;
import com.woxue.mt.entity.ProfessorApplication;

import java.util.List;
/*
* 专家申请所需要的业务逻辑接口
* */
public interface ProfessorApplicationBiz {

    //保存专家申请
    void save(ProfessorApplication professorApplication);

    //修改专家申请
    void update(ProfessorApplication professorApplication);

    //根据用户ID获取专家申请
    ProfessorApplication getByUserId(String id);

    //根据申请ID获取申请
    ProfessorApplication get(int id);

    //根据专家申请ID获取相关处理记录信息
    List<DealRecordAP> getRecords(int id);


}
