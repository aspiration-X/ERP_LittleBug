package com.littlebug.dao;

import com.littlebug.bean.COrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface COrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    COrder selectByPrimaryKey(String id);

    List<COrder> findOrderByIndexs(@Param("start")int start, @Param("end")int end);

    List<COrder> selectByIdLike(String likeId, int offset, int limit);

    List<COrder> selectOrderByProduct(String productName, int offset, int limit);

    List<COrder> selectOrderByCustom(String customName, int offset, int limit);

    List<COrder> showAllOrders();
}