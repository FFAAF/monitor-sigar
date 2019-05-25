package com.zy.monitor.controller;

import com.zy.monitor.ProcControlService.ProcControl;
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

import java.io.*;
import java.nio.charset.Charset;
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
    public List<ProcessInfo> getAllProcessInfo()throws SigarException{

        return ProcessService.getProcess(new Sigar());
    }
    @RequestMapping("/process/{size}")
    public List<ProcessInfo> getProcessInfo(@PathVariable int size)throws SigarException{

        return ProcessService.getProcess(new Sigar()).subList(0,size);
    }

    @RequestMapping("/kill/{pid}")
    public List<String> killProcess(@PathVariable long pid) throws Exception {
        return ProcControl.procKill(pid);
    }

    @RequestMapping("/suspend/{pid}")
    public List<String> suspendProcess(@PathVariable long pid) throws Exception {
        return ProcControl.procSuspend(pid);
    }

    @RequestMapping("/resume/{pid}")
    public List<String> resumeProcess(@PathVariable long pid) throws Exception {
        return ProcControl.procResume(pid);
    }

    @RequestMapping("/cpuService/{size}")
    public List<CpuService> getCpuService(@PathVariable int size){
        int length=CpuJob.getCpuServices().size();
        if(length<size)
            return CpuJob.getCpuServices();
        return CpuJob.getCpuServices() .subList(length-size,length);
    }

    @RequestMapping("/cpuService")
    public List<CpuService> getAllCpuService(){
        return CpuJob.getCpuServices();
    }
    @RequestMapping("/memService")
    public List<MemService> getAllMemService(){
        return CpuJob.getMemServices();
    }
    @RequestMapping("/memService/{size}")
    public List<MemService> getMemService(@PathVariable int size){
        int length=CpuJob.getMemServices().size();
        if(length<size)
            return CpuJob.getMemServices();
        return CpuJob.getMemServices()  .subList(length-size,length);
    }
}
