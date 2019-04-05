package com.littlebug.service.impl;

import com.littlebug.bean.Technology;
import com.littlebug.bean.TechnologyRequirement;
import com.littlebug.dao.TechnologyMapper;
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
    @Autowired
    TechnologyMapper technologyMapper;

    /**
     * 获取所有工艺要求
     * @return
     */
    @Override
    public List<TechnologyRequirement> findAllTechnologyRequirements(int page,int rows) {
        page = rows * (page -1);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.findAllTechnologyRequirements(page,rows);
        return technologyRequirements;
    }

    /**
     * 工艺要求里通过工艺ID获取单个工艺信息
     * @param technologyId
     * @return
     */
    @Override
    public Technology technologyRequirementGetTechnology(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    /**
     * 新增一个工艺要求需要查询所有工艺
     * @return
     */
    @Override
    public List<Technology> get_data() {
        List<Technology> technologyList = technologyMapper.findAllTechnologies();
        return technologyList;
    }

    /**
     * 新增一个工艺要求
     * @param technologyRequirement
     * @return
     */
    @Override
    public boolean insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        if(technologyRequirementMapper.selectByPrimaryKey(technologyRequirement.getTechnologyRequirementId())!= null){
            return false;
        }
        int i = technologyRequirementMapper.insert(technologyRequirement);
        return i == 1;
    }

    /**
     * 编辑修改一个工艺要求
     * @return
     */
    @Override
    public boolean update_all(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement);
        return i == 1;
    }

    /**
     * 删除一个或多个工艺要求
     * @param split
     * @return
     */
    @Override
    public boolean delete_batch(String[] split) {
        int i = technologyRequirementMapper.delete_batch(split);
        return i != 0;
    }
}
