package com.littlebug.dao;

import com.littlebug.bean.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
    
    

    int countAllWorks();

    List<Work> showAllWorksByIndexs(@Param("offset") int offset,
                                    @Param("limit") int limit);

    List<Work> selectWorksOnCondition(@Param("work") Work work,
                                      @Param("offset") int offset,
                                      @Param("limit") int limit);

    int countAllWorksOnCondition(@Param("work") Work work);

    List<Work> showAllWorks();
}