package com.littlebug.service.impl;

import com.littlebug.bean.FinalMeasuretCheck;
import com.littlebug.bean.ProcessCountCheck;
import com.littlebug.dao.FinalMeasuretCheckMapper;
import com.littlebug.service.FinalMeasuretCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 0:27
 */
@Service
public class FinalMeasuretCheckServiceImpl implements FinalMeasuretCheckService {
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Override
    public List<FinalMeasuretCheck> queryProcessCountCheckList(int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        List<FinalMeasuretCheck> finalMeasuretCheckList = finalMeasuretCheckMapper.selectPagination(limit,offset);
        return finalMeasuretCheckList;
    }
}
