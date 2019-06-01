package com.woxue.mt.sqldealer;

public class Comment
{
    public String id;
    public String userId;
    public String thesisId;
    public String content;
    public int score;
    public String publishTime;

    public void display()
    {
        System.out.println(
            "--评论--\n" +
            "ID：" + id + '\n' +
            "发起者ID：" + userId + '\n' +
            "论文ID：" + thesisId + '\n' +
            "内容：" + content + '\n' +
            "评分：" + score + '\n' +
            "发表时间：" + publishTime + '\n' +
            "-------------------------------------------\n");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}
