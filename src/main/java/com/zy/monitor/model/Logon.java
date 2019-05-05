package com.zy.monitor.model;

public class Logon {
    private String userId;
    private String password;
    private String level;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
