package com.zy.monitor.SigarService;

import com.zy.monitor.model.Cpu;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpuService {
    private List<Cpu> cpus;

    private double combinedPer;
    private double user;
    private double sys;
    private double nice;
    private double wait;
    private Timestamp date;

    public List<Cpu> getCpus() {
        return cpus;
    }

    public void setCpus(List<Cpu> cpus) {
        this.cpus = cpus;
    }

    public CpuService(){
    }
    public CpuService(Sigar sigar) throws SigarException {
        cpus = new ArrayList<>();
        combinedPer=0;
        user=0;
        sys=0;
        nice=0;
        wait=0;
        for (CpuPerc cpuPerc : sigar.getCpuPercList()){
            cpus.add(new Cpu(cpuPerc));
            combinedPer+=cpuPerc.getCombined();
            user+=cpuPerc.getUser();
            sys+=cpuPerc.getSys();
            nice+=cpuPerc.getNice();
            wait+=cpuPerc.getWait();
        }
        combinedPer= combinedPer/cpus.size();
        user=user/cpus.size();
        sys=sys/cpus.size();
        nice=nice/cpus.size();
        wait=wait/cpus.size();
        date=new Timestamp(System.currentTimeMillis());

    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getCombinedPer() {
        return combinedPer;
    }

    public void setCombinedPer(double combinedPer) {
        this.combinedPer = combinedPer;
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
