package com.zy.monitor.model;

public class ProcessInfo {
    private long pid;

    private String user;

    private double cpuPer;

    private long memUse;

    private String state;

    private String name;
    private String description;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getMemUse() {
        return memUse;
    }

    public void setMemUse(long memUse) {
        this.memUse = memUse;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCpuPer() {
        return cpuPer;
    }

    public void setCpuPer(double cpuPer) {
        this.cpuPer = cpuPer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
