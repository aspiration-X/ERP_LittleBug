package com.littlebug.dao;

import com.littlebug.bean.UnqualifyApply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UnqualifyApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);

    /**
     * 分页查询质量监控-不合格品管理
     * @param limit 当页显示的最大数量
     * @param offset 偏移显示的数量
     * @return
     */
    List<UnqualifyApply> selectPagination(@Param("limit") int limit, @Param("offset") int offset);
}