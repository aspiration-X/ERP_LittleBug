package com.littlebug.dao;

import com.littlebug.bean.Custom;

import java.util.List;

public interface CustomMapper {

    int countAllCustoms();

    int countCustomOnCondition(Custom custom, int offset, int limit);

    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom> selectAllCustoms();

    List<Custom> selectCustomOnCondition(Custom custom, int offset, int limit);

    List<Custom> showAllCustomsByIndexs(int offset, int limit);


}