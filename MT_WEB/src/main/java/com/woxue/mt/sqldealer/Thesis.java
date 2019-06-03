package com.woxue.mt.sqldealer;

import java.sql.Date;

//论文
public class Thesis
{
    public String id;
    public String title;
    public String author;
    public String keyword;
    public String url;
    public String summary;

    public int clickCount;
    public String averageGrade;

    //原始数据
    public String publishTime;
    public int verifyState;
    public int referenceCount;

    //本站数据
    public String professorId;
    public int score;

    public void display()
    {
        System.out.println(
            "--论文--\n" +
            "论文名字：" + title + '\n' +
            "作者：" + author + '\n' +
            "关键词：" + keyword + '\n' +
            "摘要：" + summary + '\n' +
            "论文DOI：" + id + '\n' +
            "链接：" + url + '\n' +
            " -原始数据-\n" +
            "被引次数：" + referenceCount + '\n' +
            "发表时间：" + publishTime + '\n' +
            "审核状态：" + verifyState + '\n' +
            " -本站数据-\n" +
            "科技专家ID：" + professorId + '\n' +
            "积分：" + score + '\n' +
            "-------------------------------------------\n");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(int referenceCount) {
        this.referenceCount = referenceCount;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVerifyState() {
        return verifyState;
    }

    public void setVerifyState(int verifyState) {
        this.verifyState = verifyState;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public String getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(String averageGrade) {
        this.averageGrade = averageGrade;
    }
}
