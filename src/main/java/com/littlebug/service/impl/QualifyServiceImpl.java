package com.littlebug.service.impl;

import com.littlebug.bean.UnqualifyApply;
import com.littlebug.dao.UnqualifyApplyMapper;
import com.littlebug.service.QualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by spir
 * Date2019/4/4 Time 10:38
 */
@Service
public class QualifyServiceImpl implements QualifyService {
    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;


    @Override
    public List<UnqualifyApply> queryUnqualifyList(int page,int rows) {


        int limit = rows;
        int offset = (page - 1) * rows ;

        List<UnqualifyApply> unqualifyApplyList = unqualifyApplyMapper.selectPagination(limit,offset);
        return unqualifyApplyList;
    }

    @Override
    public boolean updateAll(UnqualifyApply unqualifyApply) {
        return 1 == unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);

    }

    @Override
    public boolean deleteBatch(String ids) {
        return 1 == unqualifyApplyMapper.deleteByPrimaryKey(String.valueOf(ids));
    }
}
