package com.zy.monitor.service;

import com.zy.monitor.model.User;

import java.sql.Timestamp;
import java.util.List;

public interface UserService {
    User getByUserId(String userid);
    List<User> getAll();
    List<User> getJoinLastWeek(Timestamp lastWeek);
}
