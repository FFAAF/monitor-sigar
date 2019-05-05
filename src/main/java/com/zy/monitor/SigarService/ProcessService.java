package com.zy.monitor.SigarService;

import com.zy.monitor.model.ProcessInfo;
import org.hyperic.sigar.ProcCpu;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.Ps;

import java.util.ArrayList;
import java.util.List;

public class ProcessService {

    public static List<ProcessInfo> getProcess(Sigar sigar){
        List<ProcessInfo> processInfos = new ArrayList<>();
        Ps ps=new Ps();
        try {
            long[] pids = sigar.getProcList();
            for(long pid : pids){
                List<String> list = ps.getInfo(sigar, pid);
                ProcessInfo info = new ProcessInfo();
                for(int i = 0; i <= list.size(); i++){
                    switch(i){
                        case 0 : info.setPid(list.get(0)); break;
                        case 1 : info.setUser(list.get(1)); break;
                        case 2 : info.setStartTime(list.get(2)); break;
                        case 3 : info.setMemSize(list.get(3)); break;
                        case 4 : info.setMemUse(list.get(4)); break;
                        case 5 : info.setMemhare(list.get(5)); break;
                        case 6 : info.setState(list.get(6)); break;
                        case 7 : info.setCpuTime(list.get(7)); break;
                        case 8 : info.setName(list.get(8)); break;
                    }
                }
                ProcCpu procCpu;
                processInfos.add(info);
            }
        } catch (SigarException e) {
            e.printStackTrace();
        }

        return processInfos;
    }

}
