package com.littlebug.service.impl;

import com.littlebug.bean.Technology;
import com.littlebug.bean.TechnologyPlan;
import com.littlebug.dao.TechnologyMapper;
import com.littlebug.dao.TechnologyPlanMapper;
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
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

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
     * 通过工艺ID获取工艺详情
     * @return
     */
    @Override
    public Technology GetTechnologyByTechnologyId(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
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
    public boolean update_allTechnology(Technology technology) {
        int i = technologyMapper.updateByPrimaryKeySelective(technology);
        return i == 1;
    }

    /**
     * 删除一个或多个工艺
     * @param ids
     * @return
     */
    @Override
    public boolean delete_batchTechnology(String[] ids) {
        int i = technologyMapper.delete_batchTechnology(ids);
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




//-----------------------------------下面是TechnologyPlan的内容-------------------------------------------//




    /**
     * 获得所有的工艺计划
     * @return
     */
    @Override
    public List<TechnologyPlan> findAllTechnologyPlans() {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.findAllTechnologyPlans();
        return technologyPlans;
    }

    /**
     * 过工艺计划ID获取工艺计划详情
     * @param technologyPlanId
     * @return
     */
    @Override
    public TechnologyPlan GetTechnologyPlanByTechnologyPlanId(String technologyPlanId) {
        TechnologyPlan technologyPlan = technologyPlanMapper.selectByPrimaryKey(technologyPlanId);
        return technologyPlan;
    }

    /**
     * 新增工艺计划
     * @return
     */
    @Override
    public boolean insertTechnologyPlan(TechnologyPlan technologyPlan) {
        if(technologyPlanMapper.selectByPrimaryKey(technologyPlan.getTechnologyPlanId())!= null){
            return false;
        }
        int insert = technologyPlanMapper.insert(technologyPlan);
        return insert == 1;
    }

    /**
     * 修改工艺计划
     * @param technologyPlan
     * @return
     */
    @Override
    public boolean update_allTechnologyPlan(TechnologyPlan technologyPlan) {
        int i = technologyPlanMapper.updateByPrimaryKeySelective(technologyPlan);
        return i == 1;
    }

    /**
     * 删除一项或几项工艺计划
     * @param technologyPlanIds
     * @return
     */
    @Override
    public boolean delete_batchTechnologyPlan(String[] technologyPlanIds) {
        int i = technologyPlanMapper.delete_batchTechnologyPlan(technologyPlanIds);
        return i != 0 ;
    }

    /**
     * 通过工艺计划编号模糊查询符合要求的所有工艺计划
     * @param searchValue
     * @return
     */
    @Override
    public List<TechnologyPlan> search_technologyPlan_by_technologyPlanId(String searchValue) {
        if(null != searchValue) {
            searchValue = "%" + searchValue + "%";
        }
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.search_technologyPlan_by_technologyPlanId(searchValue);
        return technologyPlans;
    }

    /**
     * 通过工艺名称模糊查询符合要求的所有工艺计划
     * @param searchValue
     * @return
     */
    @Override
    public List<TechnologyPlan> search_technologyPlan_by_technologyName(String searchValue) {
        if(null != searchValue) {
            searchValue = "%" + searchValue + "%";
        }
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.search_technologyPlan_by_technologyName(searchValue);
        return technologyPlans;
    }


}
