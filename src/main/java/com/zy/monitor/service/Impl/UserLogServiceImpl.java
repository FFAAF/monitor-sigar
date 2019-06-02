package com.zy.monitor.service.Impl;

import com.zy.monitor.dao.UserLogMapper;
import com.zy.monitor.model.UserLog;
import com.zy.monitor.service.UserLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserLogServiceImpl implements UserLogService {
    @Resource
    private UserLogMapper userLogMapper;

    @Override
    public List<UserLog> getAll() {
        return userLogMapper.getAll();
    }

    @Override
    public List<UserLog> getById(String id) {
        return userLogMapper.getById(id);
    }

    @Override
    public List<UserLog> getBetweenDate(Timestamp from, Timestamp to) {
        return userLogMapper.getBetweenDate(from,to);
    }

    @Override
    public void addOne(UserLog userLog) {
         userLogMapper.addOne(userLog);
    }
}
