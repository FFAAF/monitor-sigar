package com.zy.monitor.controller;

import com.zy.monitor.model.User;
import com.zy.monitor.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MainController {
    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String goIndex(HttpSession session, Model model){
        if(checkLogin(session)) {
            Timestamp lastWeek= Timestamp.valueOf(LocalDateTime.now().minusWeeks(1));
            int userNum = userService.getAll().size();
            int newJoinNum=userService.getJoinLastWeek(lastWeek).size();
            model.addAttribute("userCount",userNum);
            model.addAttribute("newJoin",newJoinNum);
            model.addAttribute("id",session.getAttribute("id").toString());
            return "index";
        }
        else return "login";
    }
    @RequestMapping(value="/logon")
    public  String goLogin(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("id");
        return "login";
    }
    @RequestMapping("/cpu")
    public String goCpuInfo(){
        return "cpuInfo";
    }
    @RequestMapping("/userList")
    public String goUserList(){
        return "userList";
    }


    @RequestMapping("/test")
    public String goTest(){
        return "test";
    }


    private boolean checkLogin(HttpSession session){
        if(session.isNew()||session.getAttribute("id")==null)
            return false;
        else return true;
    }
}