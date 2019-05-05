package com.zy.monitor.controller;

import com.zy.monitor.model.Logon;
import com.zy.monitor.service.LogonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LogonController {
    @Resource
    private LogonService logonService;


    @PostMapping("/logon")
    public String logon(@RequestParam(name = "userId")String userId, @RequestParam(name = "password") String password, HttpSession session, Model model){
        Logon logon;
        logon=logonService.getByUserId(userId, password);
        if(logon==null){
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }

        session.setAttribute("id",logon.getUserId());

        return "redirect:/";
    }

}
