package com.zy.monitor.SigarService;

import com.zy.monitor.model.Cpu;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpuService {
    private List<Cpu> cpus;

    private double combinedPer;
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
        for (CpuPerc cpuPerc : sigar.getCpuPercList()){
            cpus.add(new Cpu(cpuPerc));
            combinedPer+=cpuPerc.getCombined();
        }
        combinedPer= combinedPer/cpus.size();
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
}
