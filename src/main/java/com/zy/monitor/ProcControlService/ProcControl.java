package com.zy.monitor.ProcControlService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public  class ProcControl {
    public static List<String> procKill(long pid) throws Exception{
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "taskkill /F /IM "+ pid);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        return getCmdReturn(p);
    }

    public static List<String> procSuspend(long pid)throws Exception{
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "c: && cd c:/PsTools && pssuspend  "+pid);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        return getCmdReturn(p);
    }

    public static List<String > procResume(long pid) throws Exception{
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "c: && cd c:/PsTools && pssuspend -r "+pid);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        return getCmdReturn(p);
    }




    private static List<String> getCmdReturn(Process p) throws Exception{
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
        List<String> msgs=new ArrayList<>();
        String line;

        while (true) {
            line = r.readLine();
            msgs.add(line);
            if (line == null) { break; }
        }
        return msgs;
    }
}
