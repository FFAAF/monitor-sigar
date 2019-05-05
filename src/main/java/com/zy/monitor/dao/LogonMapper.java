package com.zy.monitor.dao;

import com.zy.monitor.model.Logon;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogonMapper {
    public Logon findByUserId(String userId, String password);
}
