package com.littlebug.service.impl;

import com.littlebug.bean.ProcessMeasureCheck;
import com.littlebug.dao.ProcessMeasureCheckMapper;
import com.littlebug.service.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 3:38
 */
@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {

    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Override
    public List<ProcessMeasureCheck> selectPagination(int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        return processMeasureCheckMapper.selectPagination(limit,offset);
    }

    @Override
    public boolean pMeasurecheckinsert(ProcessMeasureCheck processMeasureCheck) {
        return 1 == processMeasureCheckMapper.insert(processMeasureCheck);

    }

    @Override
    public boolean pMeasureCheckUpdateAll(ProcessMeasureCheck processMeasureCheck) {
        return 1 == processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
    }

    @Override
    public boolean pmeasureCheckDeleteBatch(String ids) {
        return 1 == processMeasureCheckMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public List<ProcessMeasureCheck> searchpMeasureCheckByPMeasureCheckId(String searchValue, int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        searchValue = "%" + searchValue + "%";
        return processMeasureCheckMapper.searchpMeasureCheckByPMeasureCheckId(searchValue,limit,offset);
    }
}
