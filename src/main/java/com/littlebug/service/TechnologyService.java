package com.littlebug.service;

import com.littlebug.bean.Technology;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/3 Time 20:20
 */
public interface TechnologyService {
    /**
     *查询所有的工艺
     * @return List<Technology>
     */
    List<Technology> findAllTechnologies();

    /**
     * 新增一项新工艺
     * @param technology
     */
    boolean insertTechnology(Technology technology);
}
