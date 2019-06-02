package com.woxue.mt.sqldealer;

public class ProfessorOwnThesis
{
    public String professorId;
    public String thesisId;
    public String professorName;

    public void display()
    {
        System.out.println(
            "--专家拥有论文--\n" +
            "科技专家ID：" + professorId + '\n' +
            "论文ID：" + thesisId + '\n' +
            "科技专家名字：" + professorName + '\n' +
            "-------------------------------------------\n");
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getThesisId() {
        return thesisId;
    }

    public void setThesisId(String thesisId) {
        this.thesisId = thesisId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
}
