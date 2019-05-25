package com.zy.monitor.model;

import com.zy.monitor.SigarService.CpuService;

public class AlertCpu {
    private int cpuId;
    private int alertId;
    private double combined;
    private double user;
    private double sys;
    private double nice;
    private double wait;

    public AlertCpu(){}

    public AlertCpu(CpuService cpuService){
        this.setCombined(cpuService.getCombinedPer());
        this.setUser(cpuService.getUser());
        this.setNice(cpuService.getNice());
        this.setSys(cpuService.getSys());
        this.setWait(cpuService.getWait());
    }

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public int getCpuId() {
        return cpuId;
    }

    public void setCpuId(int id) {
        this.cpuId = id;
    }

    public double getCombined() {
        return combined;
    }

    public void setCombined(double combined) {
        this.combined = combined;
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
}
