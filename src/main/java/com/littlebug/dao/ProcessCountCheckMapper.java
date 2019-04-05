package com.littlebug.dao;

import com.littlebug.bean.ProcessCountCheck;

import java.util.List;

public interface ProcessCountCheckMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);


    List<ProcessCountCheck> selectPagination(int limit, int offset);
}