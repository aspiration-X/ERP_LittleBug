package com.littlebug.service.impl;

import com.littlebug.bean.Process;
import com.littlebug.dao.ProcessMapper;
import com.littlebug.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 4:23
 */
@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Process> processGetData() {
        return processMapper.selectAll();
    }

    @Override
    public Process getProcessByProcessId(String processId) {
        return processMapper.getProcessByProcessId(processId);
    }
}
