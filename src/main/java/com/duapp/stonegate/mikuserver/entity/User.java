package com.duapp.stonegate.mikuserver.entity;

import java.sql.Timestamp;

public class User {
    private int userId;
    private String userName;
    private String  passWord;
    private String userEmail;
    private int mikuType;
    private String sinaToken;
    private Timestamp createTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public int getMikuType() {
        return mikuType;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setMikuType(int mikuType) {
        this.mikuType = mikuType;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setSinaToken(String sinaToken) {
        this.sinaToken = sinaToken;
    }

    public String getSinaToken() {
        return sinaToken;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", mikuType=" + mikuType +
                ", sinaToken='" + sinaToken + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
