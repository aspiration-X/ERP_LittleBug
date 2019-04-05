package com.littlebug.dao;

import com.littlebug.bean.FinalCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    List<FinalCountCheck> selectPagination(@Param("limit") int limit, @Param("offset") int offset);

    List<FinalCountCheck> searchFCountCheckByFCountCheckId(@Param("searchValue") String searchValue, @Param("limit") int limit, @Param("offset") int offset);

    List<FinalCountCheck> searchFCountCheckByOrderId(@Param("searchValue") String searchValue, @Param("limit") int limit, @Param("offset") int offset);
}