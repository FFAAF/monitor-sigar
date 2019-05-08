package com.zy.monitor.job;

import com.zy.monitor.SigarService.CpuService;
import com.zy.monitor.model.Cpu;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
public class CpuJob {
    private static List<CpuService> cpuServices =new LinkedList<>();
    private Sigar sigar=new Sigar();
    @Scheduled(fixedRate = 1000)
    public void getCpuPerSec() throws SigarException {
        CpuService cpuService=new CpuService(sigar);
        cpuServices.add(cpuService);
    }

    public static List<CpuService> getCpuServices() {
        return cpuServices;
    }

    public void setCpuServices(List<CpuService> cpuServices) {
        this.cpuServices = cpuServices;
    }
}
