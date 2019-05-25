package com.zy.monitor.job;

import com.zy.monitor.SigarService.CpuService;
import com.zy.monitor.SigarService.MemService;
import com.zy.monitor.SigarService.ProcessService;
import com.zy.monitor.alert.SimpleAlert;
import com.zy.monitor.model.*;
import com.zy.monitor.service.AlertCpuService;
import com.zy.monitor.service.AlertProcessService;
import com.zy.monitor.service.AlertService;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
@Component
public class CpuJob {
    private static List<CpuService> cpuServices =new LinkedList<>();
    private static List<MemService> memServices=new LinkedList<>();
    private static double alertCpuPer=0.8;
    private static double alertMemPer=0.9;
    private static int size=10000;
    private Sigar sigar=new Sigar();
    @Resource
    private AlertService alertService;
    @Resource
    private AlertCpuService alertCpuService;
    @Resource
    private AlertProcessService alertProcessService;
    @Autowired
    private SimpleAlert simpleAlert;
    @Scheduled(fixedRate = 1000)
    public void getInfoPerSec() throws SigarException {
        if(cpuServices.size()>size)
            cpuServices.remove(0);
        if(memServices.size()>size)
            cpuServices.remove(0);
        CpuService cpuService=new CpuService(sigar);
        MemService memService=new MemService(sigar);

        if(cpuService.getCombinedPer()>alertCpuPer&&simpleAlert.getDelay()==0){

            simpleAlert.sendMail();
            Alert alert=new Alert(cpuService,memService, ProcessService.getProcess(sigar));
            alertService.addOne(alert);
            int alertId= alert.getAlertId();
            AlertCpu cpu=alert.getCpu();
            cpu.setAlertId(alertId);
            alertCpuService.addOne(cpu);
            for(AlertProcess process:alert.getProcesses()){
                process.setAlertId(alertId);
                alertProcessService.addOne(process);
            }

        }

        cpuServices.add(cpuService);
        memServices.add(memService);


    }


    public static void insertDB(Alert alert){

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

    public static double getAlertCpuPer() {
        return alertCpuPer;
    }

    public static void setAlertCpuPer(double alertCpuPer) {
        CpuJob.alertCpuPer = alertCpuPer;
    }

    public static double getAlertMemPer() {
        return alertMemPer;
    }

    public static void setAlertMemPer(double alertMemPer) {
        CpuJob.alertMemPer = alertMemPer;
    }
}
