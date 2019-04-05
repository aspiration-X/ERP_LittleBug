package com.littlebug.service;

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
    List<TechnologyRequirement> findAllTechnologyRequirements();
}
