package com.woxue.mt.sqldealer;

public class Trend
{
    public String id;
    public String professorId;
    public String content;
    public String publishTime;
    public String profName;

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public void display()
    {
        System.out.println(
            "--动态--\n" +
            "ID：" + id + '\n' +
            "科技专家ID：" + professorId + '\n' +
            "内容：" + content + '\n' +
            "发表时间：" + publishTime + '\n' +
            "-------------------------------------------\n");
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getProfessorId()
    {
        return professorId;
    }

    public void setProfessorId(String professorId)
    {
        this.professorId = professorId;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getPublishTime()
    {
        return publishTime;
    }

    public void setPublishTime(String publishTime)
    {
        this.publishTime = publishTime;
    }
}
