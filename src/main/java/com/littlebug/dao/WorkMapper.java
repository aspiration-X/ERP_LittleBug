package com.littlebug.dao;

import com.littlebug.bean.Work;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
    
    

    int countAllWorks();

    List<Work> showAllWorksByIndexs(int offset, int limit);

    List<Work> selectWorksOnCondition(Work work, int offset, int limit);

    int countAllWorksOnCondition(Work work);
}