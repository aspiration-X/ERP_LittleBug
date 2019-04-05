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


    /**
     * 删除一个或多个工艺要求
     * @param split
     * @return
     */
    int delete_batch(String[] split);

    /**
     * 通过工艺要求编号模糊查询符合要求的所有工艺要求
     * @param searchValue
     * @return
     */
    List<TechnologyRequirement> search_technologyRequirement_by_technologyRequirementId(@Param("searchValue") String searchValue);

    /**
     * 通过工艺名称模糊查询符合要求的所有工艺要求
     * @param searchValue
     * @return
     */
    List<TechnologyRequirement> search_technologyRequirement_by_technologyName(@Param("searchValue") String searchValue);
}