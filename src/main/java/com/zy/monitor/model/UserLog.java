package com.zy.monitor.model;

import java.sql.Timestamp;

public class UserLog {
    private int id;
    private String userId;
    private Timestamp logIn;
    private String ip;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getLogIn() {
        return logIn;
    }

    public void setLogIn(Timestamp logIn) {
        this.logIn = logIn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
