package com.littlebug.service.impl;

import com.littlebug.bean.FinalMeasuretCheck;
import com.littlebug.bean.ProcessCountCheck;
import com.littlebug.dao.FinalMeasuretCheckMapper;
import com.littlebug.service.FinalMeasuretCheckService;
import org.apache.ibatis.annotations.Param;
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

    @Override
    public boolean updateOne(FinalMeasuretCheck finalMeasuretCheck) {
        return  1 == finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
    }

    @Override
    public boolean insertMeasureCheck(FinalMeasuretCheck finalMeasuretCheck) {
        return 1 == finalMeasuretCheckMapper.insert(finalMeasuretCheck);

    }

    @Override
    public boolean deleteMeasure(String ids) {
       return 1 ==  finalMeasuretCheckMapper.deleteByPrimaryKey(ids);

    }

    @Override
    public List<FinalMeasuretCheck> searchMeasureByFMeasureCheckId(String searchValue, int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        searchValue = "%" + searchValue + "%";
        return finalMeasuretCheckMapper.searchMeasureByFMeasureCheckId( searchValue, limit, offset);
    }

    @Override
    public List<FinalMeasuretCheck> searchFMeasureCheckByOrderId(String searchValue, int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        searchValue = "%" + searchValue + "%";
        return finalMeasuretCheckMapper.searchFMeasureCheckByOrderId( searchValue, limit, offset);
    }
}
