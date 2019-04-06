package com.littlebug.service;


import java.util.List;
import com.littlebug.bean.Process;

/**
 * created by ZMX
 * Date 2019/4/5 Time 22:51
 */
public interface ProcessService {
    /**
     * 获取所有工序
     * @return
     */
    List<Process> findAllProcesses();

    /**
     * 新增工序
     * @param process
     * @return
     */
    boolean insertProcess(Process process);

    /**
     * 修改工序
     * @param process
     * @return
     */
    boolean update_allProcess(Process process);

    /**
     * 删除一项或几项工序
     * @param processIds
     * @return
     */
    boolean delete_batchProcess(String[] processIds);

    /**
     * 通过工序id模糊查询符合要求的所有工序
     * @param searchValue
     * @return
     */
    List<Process> search_process_by_processId(String searchValue);

    /**
     * 通过工艺计划ID模糊查询符合要求的所有工序
     * @param searchValue
     * @return
     */
    List<Process> search_process_by_technologyPlanId(String searchValue);


    List<Process> processGetData();

    Process getProcessByProcessId(String processId);

}
