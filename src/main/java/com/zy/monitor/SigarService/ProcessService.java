package com.zy.monitor.SigarService;

import com.zy.monitor.model.ProcessInfo;
import org.hyperic.sigar.*;
import org.hyperic.sigar.cmd.ProcInfo;
import org.hyperic.sigar.cmd.Ps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProcessService {

    public static List<ProcessInfo> getProcess(Sigar sigar) {
        List<ProcessInfo> processInfos = new ArrayList<>();
        Ps ps=new Ps();
        try {
            long[] pids = sigar.getProcList();
            double cpuCombined=new CpuService(sigar).getCombinedPer();
            for(long pid : pids){
                ProcessInfo info = new ProcessInfo();
                ProcCpu procCpu=new ProcCpu();

                try {
                    procCpu.gather(sigar, pid);
                }catch (SigarPermissionDeniedException e){
                    continue;
                }
                ProcState state=sigar.getProcState(pid);

                info.setPid(pid);
                double cpuPer=cpuCombined*procCpu .getTotal()*100/((procCpu .getLastTime()-procCpu .getStartTime())*1.0);
                info.setCpuPer(cpuPer);
//                info.setCpuPer(getCpuPercent(sigar,pid));
                info.setMemUse(sigar.getProcMem(pid).getSize());
                info.setDescription(ProcUtil.getDescription(sigar,pid));
                List<String> list = ps.getInfo(sigar, pid);
                for(int i = 0; i <= list.size(); i++){
                    switch(i){
                        case 1 : info.setUser(list.get(1)); break;
                        case 6 : info.setState(list.get(6)); break;
                        case 8 : info.setName(list.get(8)); break;
                    }
                }
                String name=info.getName();
                info.setName(name.substring(name.lastIndexOf("\\")+1));
                processInfos.add(info);
            }
        } catch (SigarException e) {
            e.printStackTrace();
        }
        processInfos.sort(Comparator.comparingDouble(ProcessInfo::getCpuPer).reversed());
        return processInfos;
    }


    private static double getCpuPercent(Sigar sigar,long pid) throws SigarException{
        long cpubegin=sigar.getCpu().getTotal();
        long proBegin=sigar.getProcCpu(pid).getTotal();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long cpuEnd=sigar.getCpu().getTotal();
        long proEnd=sigar.getProcCpu(pid).getTotal();
        double cpuPer=(proEnd-proBegin)/(cpuEnd-cpubegin);
        return cpuPer;
    }
}
