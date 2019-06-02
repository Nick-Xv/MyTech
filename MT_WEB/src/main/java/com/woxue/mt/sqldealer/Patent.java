package com.woxue.mt.sqldealer;

public class Patent
{
    public String id;
    public String name;
    public String date;
    public String applicant;
    public String inventor;
    public String agent;
    public String address;
    public String agency;
    public String provinceCode;
    public String summary;
    public String independentClaim;
    public String mainClass;
    public String patentClass;

    public void display()
    {
        System.out.println(
            "--专利--\n" +
            "专利名字：" + name + '\n' +
            "申请号：" + id + '\n' +
            "申请日：" + date + '\n' +
            "申请人：" + applicant + '\n' +
            "发明人：" + inventor + '\n' +
            "代理人：" + agent + '\n' +
            "代理机构：" + agency + '\n' +
            "地址：" + address + '\n' +
            "国省代码：" + provinceCode + '\n' +
            "摘要：" + summary + '\n' +
            "主权项：" + independentClaim + '\n' +
            "主分类号：" + mainClass + '\n' +
            "专利分类号：" + patentClass + '\n' +
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIndependentClaim() {
        return independentClaim;
    }

    public void setIndependentClaim(String independentClaim) {
        this.independentClaim = independentClaim;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getPatentClass() {
        return patentClass;
    }

    public void setPatentClass(String patentClass) {
        this.patentClass = patentClass;
    }
}
