package com.littlebug.service;

import com.littlebug.bean.Technology;
import com.littlebug.bean.TechnologyPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/3 Time 20:20
 */
public interface TechnologyService {
    /**
     *查询所有的工艺
     * @return List<Technology>
     */
    List<Technology> findAllTechnologies();

    /**
     * 通过工艺ID获取工艺详情
     * @return
     */
    Technology GetTechnologyByTechnologyId(String technologyId);

    /**
     * 新增一项新工艺
     * @param technology
     */
    boolean insertTechnology(Technology technology);

    /**
     * 修改一项工艺的某些属性
     * @return
     */
    boolean update_allTechnology(Technology technology);

    /**
     * 删除一个或多个工艺
     * @param ids
     * @return
     */
    boolean delete_batchTechnology(String[] ids);

    /**
     * 通过工艺id模糊查询符合要求的所有工艺
     * @param searchValue
     * @return
     */
    List<Technology> search_technology_by_technologyId( String searchValue);

    /**
     * 通过工艺名称模糊查询符合要求的所有工艺
     * @param searchValue
     * @return
     */
    List<Technology> search_technology_by_technologyName(String searchValue);





    //-----------------------------------下面是TechnologyPlan的内容-------------------------------------------//




    /**
     * 获得所有的工艺计划
     * @return
     */
    List<TechnologyPlan> findAllTechnologyPlans();

    /**
     * 新增工艺计划
     * @return
     */
    boolean insertTechnologyPlan(TechnologyPlan technologyPlan);

    /**
     * 修改工艺计划
     * @param technologyPlan
     * @return
     */
    boolean update_allTechnologyPlan(TechnologyPlan technologyPlan);

    /**
     * 删除一项或几项工艺计划
     * @param technologyPlanIds
     * @return
     */
    boolean delete_batchTechnologyPlan(String[] technologyPlanIds);

    /**
     * 通过工艺计划编号模糊查询符合要求的所有工艺计划
     * @param searchValue
     * @return
     */
    List<TechnologyPlan> search_technologyPlan_by_technologyPlanId(String searchValue);

    /**
     * 通过工艺名称模糊查询符合要求的所有工艺计划
     * @param searchValue
     * @return
     */
    List<TechnologyPlan> search_technologyPlan_by_technologyName(String searchValue);
}
