package com.zy.monitor.example;

import java.io.*;

public class cmdTest {
    public static void main(String[] args) throws Exception {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd c:/PsTools && pssuspend -r 23652 ");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }

        p.destroy();
        System.exit(-1);
    }
}