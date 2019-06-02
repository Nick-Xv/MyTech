package com.woxue.mt.sqldealer;

//科技专家
public class Professor
{
    public String id;
    public String name;
    public String organization;

    //原始
    public String area;
    public int referenceCount;
    public int workNumber;
    public int verifyState;

    //本站
    public String birthday;
    public String summary;
    public String title;

    public void display()
    {
        System.out.println(
            "--科技专家--\n" +
            "ID：" + id + '\n' +
            "名称：" + name + '\n' +
            "机构：" + organization + '\n' +
            " -原始数据-\n" +
            "领域：" + area + '\n' +
            "被引次数：" + referenceCount + '\n' +
            "成果数量：" + workNumber + '\n' +
            "审核状态：" + verifyState + '\n' +
            " -本站数据-\n" +
            "被引次数：" + referenceCount + '\n' +
            "成果数量：" + workNumber + '\n' +
            "审核状态：" + verifyState + '\n' +
            "-------------------------------------------\n");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(int referenceCount) {
        this.referenceCount = referenceCount;
    }

    public int getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(int workNum) {
        this.workNumber = workNum;
    }

    public int getVerifyState() {
        return verifyState;
    }

    public void setVerifyState(int verifyState) {
        this.verifyState = verifyState;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

