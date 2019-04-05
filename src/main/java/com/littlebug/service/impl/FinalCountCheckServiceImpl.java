package com.littlebug.service.impl;

import com.littlebug.bean.FinalCountCheck;
import com.littlebug.dao.FinalCountCheckMapper;
import com.littlebug.service.FinalCountCheckService;
import com.littlebug.service.FinalMeasuretCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 2:28
 */
@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public List<FinalCountCheck> fCountCheckList(int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        return finalCountCheckMapper.selectPagination(limit,offset);

    }

    @Override
    public boolean fCountCheckInsert(FinalCountCheck finalCountCheck) {
        return  1 == finalCountCheckMapper.insert(finalCountCheck);
    }

    @Override
    public boolean fCountCheckEdit(FinalCountCheck finalCountCheck) {
        return  1 == finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);

    }

    @Override
    public boolean fCountCheckDeleteBatch(String ids) {
        return 1 == finalCountCheckMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public List<FinalCountCheck> searchFCountCheckByFCountCheckId(String searchValue, int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        searchValue = "%" + searchValue + "%";
        return finalCountCheckMapper.searchFCountCheckByFCountCheckId(searchValue,limit,offset);


    }

    @Override
    public List<FinalCountCheck> searchFCountCheckByOrderId(String searchValue, int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        searchValue = "%" + searchValue + "%";
        return finalCountCheckMapper.searchFCountCheckByOrderId(searchValue,limit,offset);
    }
}
