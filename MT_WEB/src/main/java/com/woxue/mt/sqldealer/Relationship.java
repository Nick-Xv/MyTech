package com.woxue.mt.sqldealer;

public class Relationship
{
    public String masterProfessorId;
    public String masterProfessorName;
    public String slaveProfessorName;
    public String getSlaveProfessorUrl;

    public void display()
    {
        System.out.println(
            "--关系网络--\n" +
            "主专家ID：" + masterProfessorId + '\n' +
            "主专家名字：" + masterProfessorName + '\n' +
            "从专家名字：" + slaveProfessorName + '\n' +
            "从专家链接：" + getSlaveProfessorUrl + '\n' +
            "-------------------------------------------\n");
    }

    public String getMasterProfessorId() {
        return masterProfessorId;
    }

    public void setMasterProfessorId(String masterProfessorId) {
        this.masterProfessorId = masterProfessorId;
    }

    public String getMasterProfessorName() {
        return masterProfessorName;
    }

    public void setMasterProfessorName(String masterProfessorName) {
        this.masterProfessorName = masterProfessorName;
    }

    public String getSlaveProfessorName() {
        return slaveProfessorName;
    }

    public void setSlaveProfessorName(String slaveProfessorName) {
        this.slaveProfessorName = slaveProfessorName;
    }

    public String getGetSlaveProfessorUrl() {
        return getSlaveProfessorUrl;
    }

    public void setGetSlaveProfessorUrl(String getSlaveProfessorUrl) {
        this.getSlaveProfessorUrl = getSlaveProfessorUrl;
    }
}
