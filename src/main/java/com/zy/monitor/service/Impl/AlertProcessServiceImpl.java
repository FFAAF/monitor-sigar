package com.zy.monitor.service.Impl;

import com.zy.monitor.dao.AlertProcessMapper;
import com.zy.monitor.model.AlertProcess;
import com.zy.monitor.service.AlertProcessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AlertProcessServiceImpl  implements AlertProcessService {
    @Resource
    private AlertProcessMapper alertProcessMapper;
    @Override
    public void addOne(AlertProcess alertProcess) {
        alertProcessMapper.addOne(alertProcess);
    }
}
