package com.duapp.stonegate.mikuserver.serilize;

import com.duapp.stonegate.mikuserver.entity.User;

import java.io.Serializable;

/**
 * Created by chao.zhu 14-4-22 下午5:46
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -9015554614592087769L;
    private int userId;
    private String userName;
    private String passWord;
    private int mikuType;
    private String email;
    private String sinaToken;
    private String state;
    public UserDTO() {

    }

    public UserDTO(User user) {
        this.setUserId(user.getUserId());
        this.setUserName(user.getUserName());
        this.setSinaToken(user.getSinaToken());
        this.setMikuType(user.getMikuType());
        this.setEmail(user.getUserEmail());
        this.setPassWord(user.getPassWord());
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getMikuType() {
        return mikuType;
    }

    public void setMikuType(int mikuType) {
        this.mikuType = mikuType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSinaToken() {
        return sinaToken;
    }

    public void setSinaToken(String sinaToken) {
        this.sinaToken = sinaToken;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", mikuType=" + mikuType +
                ", email='" + email + '\'' +
                ", sinaToken='" + sinaToken + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public User toUser() {
        User user=new User();
        user.setPassWord(this.getPassWord());
        user.setUserName(this.getUserName());
        user.setSinaToken(this.getSinaToken());
        user.setUserEmail(this.getEmail());
        user.setMikuType(this.getMikuType());
        return user;
    }
}
