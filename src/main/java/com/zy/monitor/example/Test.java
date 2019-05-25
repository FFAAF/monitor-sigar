package com.zy.monitor.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import org.hyperic.sigar.*;

import java.nio.charset.Charset;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException{
        ProcessBuilder pb = new ProcessBuilder("taskkill /F /IM 12976");
        Process p = Runtime.getRuntime().exec("taskkill /F /IM 12976");
        BufferedReader out = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getInputStream()), Charset.forName("GB2312")));
        BufferedReader err = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getErrorStream())));
        System.out.println("Window 系统进程列表");
        String ostr;

        while ((ostr = out.readLine()) != null)
            System.out.println(ostr);
        String estr = err.readLine();
        if (estr != null) {
            System.out.println("\nError Info");
            System.out.println(estr);
        }
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
