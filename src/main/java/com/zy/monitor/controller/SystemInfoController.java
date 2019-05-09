package com.zy.monitor.controller;

import com.zy.monitor.SigarService.CpuService;
import com.zy.monitor.SigarService.FileSysService;
import com.zy.monitor.SigarService.MemService;
import com.zy.monitor.SigarService.ProcessService;
import com.zy.monitor.job.CpuJob;
import com.zy.monitor.model.Cpu;
import com.zy.monitor.model.FileSys;
import com.zy.monitor.model.Memory;
import com.zy.monitor.model.ProcessInfo;
import org.hyperic.sigar.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sys")
public class SystemInfoController {

    @RequestMapping("/cpu")
    public List<Cpu> getCpuList() throws SigarException {
        Sigar sigar=new Sigar();
        CpuService cpuService=new CpuService(sigar);
        return cpuService.getCpus();
    }

    @RequestMapping("/memory")
    public Memory getMemory() throws SigarException{
        Sigar sigar =new Sigar();
        MemService memService=new MemService(sigar);
        return memService.getMemory();
    }

    @RequestMapping("/cpuInfo")
    public CpuInfo[] getCpuInfo() throws SigarException{
        Sigar sigar = new Sigar();
        return sigar.getCpuInfoList();
    }

    @RequestMapping("/fileSys")
    public List<FileSys> getFileSys() throws SigarException{
        Sigar sigar=new Sigar();
        return FileSysService.getFilesys(sigar);
    }

    @RequestMapping("/process")
    public List<ProcessInfo> getProcessInfo(){
        return ProcessService.getProcess(new Sigar());
    }

    @RequestMapping("/cpuService/{size}")
    public List<CpuService> getCpuService(@PathVariable int size){
        int length=CpuJob.getCpuServices().size();
        if(length<size)
            return CpuJob.getCpuServices();
        return CpuJob.getCpuServices()  .subList(length-size,length);
    }

    @RequestMapping("/cpuService")
    public List<CpuService> getAllCpuService(){
        return CpuJob.getCpuServices();
    }
}
