package com.zy.monitor.controller;

import com.zy.monitor.SigarService.CpuService;
import com.zy.monitor.SigarService.MemService;
import com.zy.monitor.SigarService.ProcessService;
import com.zy.monitor.model.Alert;
import com.zy.monitor.model.AlertCpu;
import com.zy.monitor.model.AlertProcess;
import com.zy.monitor.model.ProcessInfo;
import com.zy.monitor.service.AlertCpuService;
import com.zy.monitor.service.AlertProcessService;
import com.zy.monitor.service.AlertService;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/alert")
public class AlertController {
    @Resource
    private AlertService alertService;
    @Resource
    private AlertCpuService alertCpuService;
    @Resource
    private AlertProcessService alertProcessService;
    @RequestMapping("/getAll")
    public List<Alert> getAllAlerts(){
        return alertService.getAll();
    }
    @RequestMapping("/addOne")
    public Alert add() throws SigarException {
        Sigar sigar=new Sigar();
        CpuService cpuService=new CpuService(sigar);
        MemService memService=new MemService(sigar);
        Alert alert=new Alert(cpuService,memService, ProcessService.getProcess(sigar));
        alertService.addOne(alert);
        AlertCpu cpu=alert.getCpu();
        cpu.setAlertId(alert.getAlertId());
        alertCpuService.addOne(cpu);
        for(AlertProcess process:alert.getProcesses()){
            process.setAlertId(alert.getAlertId());
            alertProcessService.addOne(process);
        }
        return alert;
    }

}
