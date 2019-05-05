package com.zy.monitor.service.Impl;

import com.zy.monitor.dao.LogonMapper;
import com.zy.monitor.model.Logon;
import com.zy.monitor.service.LogonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogonServiceImpl implements LogonService {
    @Resource
    private LogonMapper logonMapper;

    @Override
    public Logon getByUserId(String userId, String password) {
        return logonMapper.findByUserId(userId,password);
    }
}

