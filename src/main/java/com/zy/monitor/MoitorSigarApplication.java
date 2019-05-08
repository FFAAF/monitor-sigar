package com.zy.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MoitorSigarApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoitorSigarApplication.class, args);
    }

}
