package com.zy.monitor.dao;

import com.zy.monitor.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    int countAll();
    User findByUserId(String userId);
    List<User> findJoinLastWeek(Timestamp lastWeek);

}
