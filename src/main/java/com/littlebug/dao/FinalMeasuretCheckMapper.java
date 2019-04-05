package com.littlebug.dao;

import com.littlebug.bean.FinalMeasuretCheck;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 成品计量质检
 */
public interface FinalMeasuretCheckMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    /**
     * 分页查询
     * @param limit
     * @param offset
     * @return
     */
    List<FinalMeasuretCheck> selectPagination(@Param("limit") int limit, @Param("offset") int offset);
}