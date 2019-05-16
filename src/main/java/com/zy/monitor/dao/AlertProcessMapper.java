package com.zy.monitor.dao;

import com.zy.monitor.model.AlertProcess;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlertProcessMapper {
    void addOne(AlertProcess alertProcess);
}
