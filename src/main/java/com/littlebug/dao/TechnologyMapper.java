package com.littlebug.dao;

import com.littlebug.bean.Technology;

import java.util.List;

public interface TechnologyMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    /**
     * 查询所有的工艺
     * @return List<Technology>
     */
    List<Technology> findAllTechnologies();

    /**
     * 删除一个或多个工艺
     * @param ids
     * @return
     */
    int delete_batch(List<String> ids);
}