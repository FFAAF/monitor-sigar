package com.zy.monitor.dao;

import com.zy.monitor.model.Alert;
import com.zy.monitor.model.AlertCpu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlertCpuMapper {

    void addOne(AlertCpu alertCpu);
}
