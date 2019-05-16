package com.zy.monitor.dao;

import com.zy.monitor.model.Alert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlertMapper {
    int getLastId();
    List<Alert> findAll();
    void addOne(Alert alert);
}
