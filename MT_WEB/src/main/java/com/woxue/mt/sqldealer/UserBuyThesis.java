package com.woxue.mt.sqldealer;

public class UserBuyThesis
{
    public String userId;
    public String thesisId;

    public void display()
    {
        System.out.println(
            "--用户购买的论文--\n" +
            "用户ID：" + userId + '\n' +
            "论文ID：" + thesisId + '\n' +
            "-------------------------------------------\n");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getThesisId() {
        return thesisId;
    }

    public void setThesisId(String thesisId) {
        this.thesisId = thesisId;
    }
}
