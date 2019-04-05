package com.littlebug.dao;

import com.littlebug.bean.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    /**
     * 获取所有工序
     * @return
     */
    List<Process> findAllProcesses();

    /**
     * 删除一项或几项工序
     * @param processIds
     * @return
     */
    int delete_batchProcess(String[] processIds);

    /**
     * 通过工序id模糊查询符合要求的所有工序
     * @param searchValue
     * @return
     */
    List<Process> search_process_by_processId(@Param("searchValue") String searchValue);

    /**
     * 通过工艺计划ID模糊查询符合要求的所有工序
     * @param searchValue
     * @return
     */
    List<Process> search_process_by_technologyPlanId(@Param("searchValue")String searchValue);
}