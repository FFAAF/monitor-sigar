package com.zy.monitor.model;

public class AlertProcess {
    private int id;
    private int alertId;
    private long pid;
    private String name;
    private double cpu;
    private double mem;


    public AlertProcess(){}
    public AlertProcess(ProcessInfo info){
        this.setCpu(info.getCpuPer());
        this.setMem(info.getMemUse());
        this.setName(info.getName());
        this.setPid(info.getPid());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getMem() {
        return mem;
    }

    public void setMem(double mem) {
        this.mem = mem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
