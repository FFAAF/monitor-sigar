package com.zy.monitor.model;

import java.sql.Timestamp;

public class User {
    private String userId;
    private String name;
    private Timestamp joinTime;

    public String getName() {
        return name;
    }

    public Timestamp getJoinTime() {
        return joinTime;
    }

    public String getUserid() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }

}
