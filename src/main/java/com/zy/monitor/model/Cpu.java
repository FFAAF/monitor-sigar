package com.zy.monitor.model;

import org.hyperic.sigar.CpuPerc;

public class Cpu {
    private double user;
    private double sys;
    private double nice;
    private double wait;
    private double combined;

    public Cpu(){}

    public Cpu(CpuPerc cpuPerc){
        this.setUser(cpuPerc.getUser());
        this.setSys(cpuPerc.getSys());
        this.setNice(cpuPerc.getNice());
        this.setWait(cpuPerc.getWait());
        this.setCombined(cpuPerc.getCombined());
    }
    public double getUser() {
        return user;
    }

    public void setUser(double user) {
        this.user = user;
    }

    public double getSys() {
        return sys;
    }

    public void setSys(double sys) {
        this.sys = sys;
    }

    public double getNice() {
        return nice;
    }

    public void setNice(double nice) {
        this.nice = nice;
    }

    public double getWait() {
        return wait;
    }

    public void setWait(double wait) {
        this.wait = wait;
    }

    public double getCombined() {
        return combined;
    }

    public void setCombined(double combined) {
        this.combined = combined;
    }

}
