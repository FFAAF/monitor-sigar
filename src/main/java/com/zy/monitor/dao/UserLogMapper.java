package com.zy.monitor.dao;

import com.zy.monitor.model.UserLog;
import org.apache.ibatis.annotations.Mapper;

import javax.jws.soap.SOAPBinding;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserLogMapper {

    List<UserLog> getAll();
    List<UserLog> getById(String id);
    List<UserLog> getBetweenDate(Timestamp from,Timestamp to);
    void addOne(UserLog userLog);
}
