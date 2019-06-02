package com.zy.monitor.controller;

import com.zy.monitor.model.Logon;
import com.zy.monitor.model.UserLog;
import com.zy.monitor.service.LogonService;
import com.zy.monitor.service.UserLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogonController {
    @Resource
    private LogonService logonService;
    @Resource
    private UserLogService userLogService;


    @PostMapping("/logon")
    public String logon(@RequestParam(name = "userId")String userId, @RequestParam(name = "password") String password, HttpSession session, Model model, HttpServletRequest request){
        Logon logon;
        logon=logonService.getByUserId(userId, password);
        if(logon==null){
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }
        String ip;
        if (request.getHeader("x-forwarded-for") == null) {
             ip= request.getRemoteAddr();
        }
        else ip= request.getHeader("x-forwarded-for");
        session.setAttribute("id",logon.getUserId());
        UserLog userLog=new UserLog();
        userLog.setUserId(logon.getUserId());
        userLog.setIp(ip);
        userLogService.addOne(userLog);
        return "redirect:/";
    }

}
