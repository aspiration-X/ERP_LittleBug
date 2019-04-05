package com.littlebug.service;

import com.littlebug.bean.Technology;
import com.littlebug.bean.TechnologyRequirement;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/5 Time 0:23
 */
public interface TechnologyRequirementService {
    /**
     * 获取所有工艺要求
     * @return
     */
    List<TechnologyRequirement> findAllTechnologyRequirements(int page,int rows);

    /**
     * 工艺要求里通过工艺ID获取单个工艺信息
     * @param technologyId
     * @return
     */
    Technology technologyRequirementGetTechnology(String technologyId);

    /**
     * 新增一个工艺要求需要查询所有工艺
     * @return
     */
    List<Technology> get_data();

    /**
     * 新增一个工艺要求
     * @param technologyRequirement
     * @return
     */
    boolean insertTechnologyRequirement(TechnologyRequirement technologyRequirement);

    /**
     * 编辑修改一个工艺要求
     * @return
     */
    boolean update_all(TechnologyRequirement technologyRequirement);

    /**
     * 删除一个或多个工艺要求
     * @param split
     * @return
     */
    boolean delete_batch(String[] split);
}
