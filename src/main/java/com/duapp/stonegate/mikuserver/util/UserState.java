package com.duapp.stonegate.mikuserver.util;

import java.net.InetAddress;

public class UserState {
    private String userName;
    private String userIpAddress;
    private String userState;

    public UserState(String userName, String userState, InetAddress ipAddress) {
        this.userName = userName;
        this.userState = userState;
        userIpAddress = ipAddress.getHostAddress();
    }

    public String getUserIpAddress() {
        if (this.userState.equals(MikuConst.ONLINE))
            return userIpAddress;
        else
            return null;
    }

    public void setUserIpAddress(String userIpAddress) {
        this.userIpAddress = userIpAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }
}
