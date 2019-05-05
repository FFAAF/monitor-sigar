package com.zy.monitor.service.Impl;


import com.zy.monitor.dao.UserMapper;
import com.zy.monitor.model.User;
import com.zy.monitor.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.findAll();
    }

    @Override
    public User getByUserId(String userId) {
        return userMapper.findByUserId(userId);
    }

    @Override
    public List<User> getJoinLastWeek(Timestamp lastWeek) {
        return userMapper.findJoinLastWeek(lastWeek);
    }
}
