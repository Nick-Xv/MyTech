package com.woxue.mt.sqldealer;

public class User
{
    public String id;
    public String focusArea;
    public String nickname;
    public String password;
    public String phoneNumber;
    public String email;
    public int score;

    public void display()
    {
        System.out.println(
            "--用户--\n" +
            "ID：" + id + '\n' +
            "关注领域：" + focusArea + '\n' +
            "昵称：" + nickname + '\n' +
            "密码：" + password + '\n' +
            "手机号：" + phoneNumber + '\n' +
            "邮箱：" + email + '\n' +
            "积分值：" + score + '\n' +
            "-------------------------------------------\n");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFocusArea() {
        return focusArea;
    }

    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
