package com.zy.monitor.service;

import com.zy.monitor.model.Alert;

import java.util.List;

public interface AlertService {
    List<Alert> getAll();
    int getLastId();
    void addOne(Alert alert);
}
