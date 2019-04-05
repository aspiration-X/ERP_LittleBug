package com.littlebug.dao;

import com.littlebug.bean.TechnologyPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    /**
     * 获得所有的工艺计划
     * @return
     */
    List<TechnologyPlan> findAllTechnologyPlans();

    /**
     * 删除一项或几项工艺计划
     * @param technologyPlanIds
     * @return
     */
    int delete_batchTechnologyPlan(String[] technologyPlanIds);

    /**
     * 通过工艺计划编号模糊查询符合要求的所有工艺计划
     * @param searchValue
     * @return
     */
    List<TechnologyPlan> search_technologyPlan_by_technologyPlanId(@Param("searchValue") String searchValue);

    /**
     * 通过工艺名称模糊查询符合要求的所有工艺计划
     * @param searchValue
     * @return
     */
    List<TechnologyPlan> search_technologyPlan_by_technologyName(@Param("searchValue") String searchValue);
}