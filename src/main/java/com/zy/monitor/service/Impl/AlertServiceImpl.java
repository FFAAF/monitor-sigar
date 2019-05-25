package com.zy.monitor.service.Impl;

import com.zy.monitor.dao.AlertMapper;
import com.zy.monitor.model.Alert;
import com.zy.monitor.service.AlertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    @Resource
    AlertMapper alertMapper;

    @Override
    public List<Alert> getAll() {
        return alertMapper.findAll();
    }


    @Override
    public void addOne(Alert alert) {
        alertMapper.addOne(alert);
    }
}
