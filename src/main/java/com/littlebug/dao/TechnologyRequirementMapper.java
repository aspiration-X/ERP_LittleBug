package com.littlebug.dao;

import com.littlebug.bean.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    /**
     * 获取所有工艺要求
     * @return
     */
    List<TechnologyRequirement> findAllTechnologyRequirements(@Param("page") int page, @Param("rows") int rows);


}