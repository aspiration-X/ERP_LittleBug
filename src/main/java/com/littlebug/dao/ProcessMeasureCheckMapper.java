package com.littlebug.dao;

import com.littlebug.bean.ProcessMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMeasureCheckMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> selectPagination(@Param("limit") int limit,@Param("offset") int rows);

    List<ProcessMeasureCheck> searchpMeasureCheckByPMeasureCheckId(@Param("searchValue") String searchValue, @Param("limit") int limit,@Param("offset") int offset);
}