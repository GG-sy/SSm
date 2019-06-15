package com.cnsdhh.service.impl;

import com.cnsdhh.dao.LogDao;
import com.cnsdhh.domain.Log;
import com.cnsdhh.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    private final LogDao logDao;

    @Autowired
    public LogServiceImpl(LogDao logDao) {
        this.logDao = logDao;
    }

    // 日志插入
    @Override
    public void insertLog(Log log) {
        logDao.insertLog(log);
    }
}
