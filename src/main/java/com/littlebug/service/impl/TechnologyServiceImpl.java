package com.littlebug.service.impl;

import com.littlebug.bean.Technology;
import com.littlebug.dao.TechnologyMapper;
import com.littlebug.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/3 Time 20:21
 */
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("technologyService")
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;

    /**
     * 查询所有的工艺
     * @return List<Technology>
     */

    @Override
    public List<Technology> findAllTechnologies() {
        List<Technology> technologyList = technologyMapper.findAllTechnologies();
        return technologyList;
    }

    /**
     * 新增一项新工艺
     * @param technology
     */
    @Override
    public boolean insertTechnology(Technology technology) {
        int insert = technologyMapper.insert(technology);
        return insert == 1;
    }
}
