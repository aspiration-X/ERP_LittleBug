package com.littlebug.service;

import com.littlebug.bean.ProcessCountCheck;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 5:17
 */
public interface ProcessCountCheckService {
    List<ProcessCountCheck> pCountcheckList(int page, int rows);

    boolean pCountCheckInser(ProcessCountCheck processCountCheck);

    boolean pCountCheckUpdateAll(ProcessCountCheck processCountCheck);

    boolean pCountCheckDeleteBatch(String ids);

    List<ProcessCountCheck> searchPCountCheckByPCountCheckId(String searchValue, int page, int rows);

}
