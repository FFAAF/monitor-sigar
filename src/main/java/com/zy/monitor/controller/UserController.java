package com.zy.monitor.controller;


import com.zy.monitor.model.User;
import com.zy.monitor.model.UserLog;
import com.zy.monitor.service.UserLogService;
import com.zy.monitor.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    UserLogService userLogService;
    @RequestMapping("/allUser")
    public List<User> allUser(){
        return userService.getAll();
    }

    @RequestMapping("/logs")
    public List<UserLog> allLogs(){
        return userLogService.getAll();
    }
}
