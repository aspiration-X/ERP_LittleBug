package com.littlebug.service;

import com.littlebug.bean.ProcessMeasureCheck;
import com.littlebug.dao.ProcessMeasureCheckMapper;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 3:38
 */
public interface ProcessMeasureCheckService {
    List<ProcessMeasureCheck> selectPagination(int page, int rows);

    boolean pMeasurecheckinsert(ProcessMeasureCheck processMeasureCheck);

    boolean pMeasureCheckUpdateAll(ProcessMeasureCheck processMeasureCheck);

    boolean pmeasureCheckDeleteBatch(String ids);

    List<ProcessMeasureCheck> searchpMeasureCheckByPMeasureCheckId(String searchValue, int page, int rows);
}
