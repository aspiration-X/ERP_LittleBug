package com.littlebug.service.impl;

import com.littlebug.bean.TechnologyRequirement;
import com.littlebug.dao.TechnologyRequirementMapper;
import com.littlebug.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/5 Time 0:24
 */
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("TechnologyRequirementService")
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    /**
     * 获取所有工艺要求
     * @return
     */
    @Override
    public List<TechnologyRequirement> findAllTechnologyRequirements() {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.findAllTechnologyRequirements();
        return technologyRequirements;
    }
}
