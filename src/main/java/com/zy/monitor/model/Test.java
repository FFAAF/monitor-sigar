package com.zy.monitor.model;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import org.hyperic.sigar.*;

import java.util.Properties;

public class Test {
    public static void main(String[] args) throws SigarException {
        Properties props = System.getProperties();
        Sigar sigar = new Sigar();
        SysInfo sysInfo = new SysInfo();
        CpuPerc cpuCerc;
        Mem mem;
        OperatingSystem OS ;
        OS = OperatingSystem.getInstance();
        cpuCerc = sigar.getCpuPerc();
        mem = sigar.getMem();
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(props.getProperty("os.name")+" "+OS.getDescription());
        System.out.println("<br>总使用率: "
                + String.format("%.2f ", cpuCerc.getCombined() * 100)
                + "%" + "<br>用户使用率(user): "
                + String.format("%.2f ", cpuCerc.getUser() * 100) + "%"
                + "<br>系统使用率(sys): "
                + String.format("%.2f ", cpuCerc.getSys() * 100) + "%"
                + "<br>当前空闲率(idle): "
                + String.format("%.2f ", cpuCerc.getIdle() * 100) + "%");
        System.out.println("<br>内存总量：" + mem.getTotal() / 1024 / 1024
                + "M" + "<br>已使用内存：" + mem.getUsed() / 1024 / 1024
                + "M" + "<br>剩余内存：" + mem.getFree() / 1024 / 1024 + "M");
        System.out.println(getMemery());
    }
    public static String getMemery() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        // 总的物理内存+虚拟内存
        long totalvirtualMemory = osmxb.getTotalSwapSpaceSize();
        // 剩余的物理内存
        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        Double compare = (Double) (1 - freePhysicalMemorySize * 1.0
                / totalvirtualMemory) * 100;
        String str = "内存已使用:" + compare.intValue() + "%";
        return str;
    }
}
