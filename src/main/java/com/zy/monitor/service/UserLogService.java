package com.zy.monitor.service;

import com.zy.monitor.model.UserLog;

import java.sql.Timestamp;
import java.util.List;

public interface UserLogService {
    List<UserLog> getAll();
    List<UserLog> getById(String id);
    List<UserLog> getBetweenDate(Timestamp from, Timestamp to);
    void addOne(UserLog userLog);
}
