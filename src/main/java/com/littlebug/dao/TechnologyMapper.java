package com.littlebug.dao;

import com.littlebug.bean.Technology;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 通过工艺id模糊查询符合要求的所有工艺
     * @param searchValue
     * @return
     */
    List<Technology> search_technology_by_technologyId(@Param("technologyId") String searchValue);

    /**
     * 通过工艺名称模糊查询符合要求的所有工艺
     * @param searchValue
     * @return
     */
    List<Technology> search_technology_by_technologyName(@Param("technologyName") String searchValue);
}