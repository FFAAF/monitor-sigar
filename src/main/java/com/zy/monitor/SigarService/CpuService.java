package com.zy.monitor.SigarService;

import com.zy.monitor.model.Cpu;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpuService {
    private List<Cpu> cpus;

    private Date date;

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
        for (CpuPerc cpuPerc : sigar.getCpuPercList())
            cpus.add(new Cpu(cpuPerc));
        date=new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
