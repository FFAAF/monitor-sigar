package com.zy.monitor.alert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SimpleAlert {
    @Autowired
    private  JavaMailSender mailSender;
    private  int delay=0;
    public  void sendMail(){
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setFrom("zyzhang1997@163.com");
        mail.setTo("zyzhang1997@163.com");
        mail.setText("There's a alert in the system");
        mail.setSubject("Alert");
        mailSender.send(mail);
    }

    public  int getDelay() {
        return delay;
    }

    public  void setDelay(int delay) {
        this.delay = delay;
    }
}
