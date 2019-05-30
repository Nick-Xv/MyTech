package com.woxue.mt.dao;

import com.woxue.mt.entity.DealRecordAP;
import com.woxue.mt.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DealRecordAPDao")
public interface DealRecordAPDao {
    void insert(DealRecordAP dealRecordAP);
    List<DealRecordAP> selectByApId(int apId);
}
