package com.zy.monitor.model;

import java.sql.Timestamp;

public class UserLog {
    private String id;
    private Timestamp logIn;
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
