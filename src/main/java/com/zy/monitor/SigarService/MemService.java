package com.zy.monitor.SigarService;

import com.zy.monitor.model.Memory;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class MemService {
    private Memory memory;
    public MemService(){

    }
    public MemService(Sigar sigar) throws SigarException {
       memory=new Memory(sigar.getMem()) ;
    }
    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}
