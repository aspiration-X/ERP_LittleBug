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

    /**
     * 通过工艺要求编号模糊查询符合要求的所有工艺要求
     * @param searchValue
     * @return
     */
    List<TechnologyRequirement> search_technologyRequirement_by_technologyRequirementId(String searchValue);

    /**
     * 通过工艺名称模糊查询符合要求的所有工艺要求
     * @param searchValue
     * @return
     */
    List<TechnologyRequirement> search_technologyRequirement_by_technologyName(String searchValue);
}
