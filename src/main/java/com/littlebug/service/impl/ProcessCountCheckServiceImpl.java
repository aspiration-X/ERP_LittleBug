package com.littlebug.service.impl;

import com.littlebug.bean.ProcessCountCheck;
import com.littlebug.dao.ProcessCountCheckMapper;
import com.littlebug.service.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 5:17
 */
@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {

    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @Override
    public List<ProcessCountCheck> pCountcheckList(int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        return processCountCheckMapper.pCountcheckList(limit,offset);

    }

    @Override
    public boolean pCountCheckInser(ProcessCountCheck processCountCheck) {

        return 1 == processCountCheckMapper.insert(processCountCheck);
    }

    @Override
    public boolean pCountCheckUpdateAll(ProcessCountCheck processCountCheck) {
        return 1 == processCountCheckMapper.updateByPrimaryKey(processCountCheck);
    }

    @Override
    public boolean pCountCheckDeleteBatch(String ids) {
        return 1 == processCountCheckMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public List<ProcessCountCheck> searchPCountCheckByPCountCheckId(String searchValue, int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        searchValue = "%" + searchValue + "%";
        return processCountCheckMapper.searchPCountCheckByPCountCheckId(searchValue,limit,offset);
    }


}
