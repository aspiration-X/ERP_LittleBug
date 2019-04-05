package com.littlebug.service;

import com.littlebug.bean.Process;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 4:23
 */
public interface ProcessService {
    List<Process> processGetData();

    Process getProcessByProcessId(String processId);
}
