package com.zy.monitor.job;

import com.zy.monitor.SigarService.CpuService;
import com.zy.monitor.SigarService.MemService;
import com.zy.monitor.model.Cpu;
import com.zy.monitor.model.Memory;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
public class CpuJob {
    private static List<CpuService> cpuServices =new LinkedList<>();
    private static List<MemService> memServices=new LinkedList<>();

    private Sigar sigar=new Sigar();
    @Scheduled(fixedRate = 1000)
    public void getInfoPerSec() throws SigarException {
        cpuServices.add(new CpuService(sigar));
        memServices.add(new MemService(sigar));


    }

    public static List<CpuService> getCpuServices() {
        return cpuServices;
    }

    public void setCpuServices(List<CpuService> cpuServices) {
        this.cpuServices = cpuServices;
    }

    public static List<MemService> getMemServices() {
        return memServices;
    }

    public static void setMemServices(List<MemService> memServices) {
        CpuJob.memServices = memServices;
    }
}
