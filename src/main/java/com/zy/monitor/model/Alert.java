package com.zy.monitor.model;

import com.zy.monitor.SigarService.CpuService;
import com.zy.monitor.SigarService.MemService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Alert {
    private int alertId;
    private Timestamp alertTime;
    private AlertCpu cpu;
    private double memUse;
    private List<AlertProcess> processes;

    public Alert(){}

    public Alert(CpuService cpuService, MemService memService,List<ProcessInfo> processInfos){
        this.setAlertTime(cpuService.getDate());
        this.setMemUse(memService.getMemory().getUsedPercent());
        this.setCpu(new AlertCpu());
        processes=new LinkedList<>();
        for(ProcessInfo info:processInfos){
            processes.add(new AlertProcess(info));
        }
    }


    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public Timestamp getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Timestamp alertTime) {
        this.alertTime = alertTime;
    }

    public AlertCpu getCpu() {
        return cpu;
    }

    public void setCpu(AlertCpu cpu) {
        this.cpu = cpu;
    }

    public double getMemUse() {
        return memUse;
    }

    public void setMemUse(double memUse) {
        this.memUse = memUse;
    }

    public List<AlertProcess> getProcesses() {
        return processes;
    }

    public void setProcesses(List<AlertProcess> processes) {
        this.processes = processes;
    }
}
