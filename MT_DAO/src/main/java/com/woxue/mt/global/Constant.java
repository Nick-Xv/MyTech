package com.woxue.mt.global;

import java.util.ArrayList;
import java.util.List;
/*
* 这个类里面保存着一些常量字段，和获取常量字段的方法
* */
public class Constant {
    //角色
    public static final String CHAR_USER = "普通用户";
    public static final String CHAR_EXPERT = "专家用户";
    public static final String CHAR_ADMIN = "管理员";

    //获得角色列表
    public static List<String> getChars(){
        List<String> list = new ArrayList<String>();
        list.add(CHAR_USER);
        list.add(CHAR_EXPERT);
        list.add(CHAR_ADMIN);
        return list;
    }

    //专家申请状态
    public static final String APPLICATION_CREATED = "新创建";
    public static final String APPLICATION_CHANGED = "已修改";
    public static final String APPLICATION_DENIED = "已驳回";
    public static final String APPLICATION_ACCEPTED = "已通过";


    //其余的不变量等待放置在这里
}
