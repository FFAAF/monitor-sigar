package com.zy.monitor.service;

import com.zy.monitor.model.Logon;

public interface LogonService {
    public Logon getByUserId(String userId, String password);
}
