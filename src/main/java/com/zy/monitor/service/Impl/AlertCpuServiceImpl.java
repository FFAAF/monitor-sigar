package com.zy.monitor.service.Impl;

import com.zy.monitor.dao.AlertCpuMapper;
import com.zy.monitor.model.AlertCpu;
import com.zy.monitor.service.AlertCpuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AlertCpuServiceImpl implements AlertCpuService {
    @Resource
    private AlertCpuMapper alertCpuMapper;
    @Override
    public void addOne(AlertCpu alertCpu) {
        alertCpuMapper.addOne(alertCpu);
    }
}
