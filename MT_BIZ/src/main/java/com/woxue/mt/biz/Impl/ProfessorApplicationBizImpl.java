package com.woxue.mt.biz.Impl;

import com.woxue.mt.biz.ProfessorApplicationBiz;
import com.woxue.mt.dao.DealRecordAPDao;
import com.woxue.mt.dao.ProfessorApplicationDao;
import com.woxue.mt.entity.DealRecordAP;
import com.woxue.mt.entity.ProfessorApplication;
import com.woxue.mt.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
 * 专家申请所需要的业务逻辑接口实现类
 * */
@Service("ProfessorApplicationBiz")
public class ProfessorApplicationBizImpl implements ProfessorApplicationBiz {

    //注入需要使用到的持久化操作对象
    @Autowired
    private ProfessorApplicationDao professorApplicationDao;
    @Autowired
    private DealRecordAPDao dealRecordAPDao;

    //保存专家申请
    public void save(ProfessorApplication professorApplication) {
        //系统当前时间即为申请时间
        professorApplication.setTime(new Date());
        //设置申请状态为新创建
        professorApplication.setState(Constant.APPLICATION_CREATED);
        //调用持久化操作对象进行插入
        professorApplicationDao.insert(professorApplication);
    }

    //修改专家申请
    public void update(ProfessorApplication professorApplication) {
        professorApplicationDao.update(professorApplication);
    }

    //根据用户ID获取专家申请
    public ProfessorApplication getByUserId(String id) {
        return professorApplicationDao.selectByUserId(id);
    }

    public ProfessorApplication get(int id) {
        return professorApplicationDao.select(id);
    }

    //根据专家申请ID获取相关处理记录信息
    public List<DealRecordAP> getRecords(int id) {
        return dealRecordAPDao.selectByApId(id);
    }
}
