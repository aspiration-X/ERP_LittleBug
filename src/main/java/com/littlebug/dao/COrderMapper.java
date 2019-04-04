package com.littlebug.dao;

import com.littlebug.bean.COrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface COrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    COrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    List<COrder> findOrderByIndexs(@Param("start")int start, @Param("end")int end);
}