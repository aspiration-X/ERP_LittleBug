package com.littlebug.service.impl;

import com.littlebug.bean.Technology;
import com.littlebug.dao.TechnologyMapper;
import com.littlebug.service.TechnologyService;
import org.apache.ibatis.annotations.Param;
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
        if(technologyMapper.selectByPrimaryKey(technology.getTechnologyId())!= null){
            return false ;
        }
        int insert = technologyMapper.insert(technology);
        return insert == 1;
    }

    /**
     * 修改一项工艺的某些属性
     * @return
     */
    @Override
    public boolean update_all(Technology technology) {
        int i = technologyMapper.updateByPrimaryKeySelective(technology);
        return i == 1;
    }

    /**
     * 删除一个或多个工艺
     * @param ids
     * @return
     */
    @Override
    public boolean delete_batch(String[] ids) {
        int i = technologyMapper.delete_batch(ids);
        return i != 0;
    }

    /**
     * 通过工艺id模糊查询符合要求的所有工艺
     * @param searchValue
     * @return
     */
    @Override
    public List<Technology> search_technology_by_technologyId(String searchValue) {
        if(null != searchValue) {
            searchValue = "%" + searchValue + "%";
        }
        List<Technology> technologies = technologyMapper.search_technology_by_technologyId( searchValue);
        return technologies;
    }

    /**
     * 通过工艺名称模糊查询符合要求的所有工艺
     * @param searchValue
     * @return
     */
    @Override
    public List<Technology> search_technology_by_technologyName(String searchValue) {
        if(null != searchValue) {
            searchValue = "%" + searchValue + "%";
        }
        List<Technology> technologies = technologyMapper.search_technology_by_technologyName( searchValue);
        return technologies;
    }

}
