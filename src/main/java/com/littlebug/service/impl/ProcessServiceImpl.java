package com.littlebug.service.impl;


import com.littlebug.dao.ProcessMapper;
import com.littlebug.bean.Process;
import com.littlebug.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("processService")
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;

    /**
     * 获取所有工序
     * @return
     */
    @Override
    public List<Process> findAllProcesses() {
        List<Process> processes = processMapper.findAllProcesses();
        return processes;
    }

    /**
     * 新增工序
     * @param process
     * @return
     */
    @Override
    public boolean insertProcess(Process process) {
        if(processMapper.selectByPrimaryKey(process.getProcessId()) != null){
            return false;
        }
        int insert = processMapper.insert(process);
        return insert == 1;
    }

    /**
     * 修改工序
     * @param process
     * @return
     */
    @Override
    public boolean update_allProcess(Process process) {
        int i = processMapper.updateByPrimaryKeySelective(process);
        return i == 1;
    }

    /**
     * 删除一项或几项工序
     * @param processIds
     * @return
     */
    @Override
    public boolean delete_batchProcess(String[] processIds) {
        int i = processMapper.delete_batchProcess(processIds);
        return i != 0;
    }

    /**
     * 通过工序id模糊查询符合要求的所有工序
     * @param searchValue
     * @return
     */
    @Override
    public List<Process> search_process_by_processId(String searchValue) {
        if(null != searchValue) {
            searchValue = "%" + searchValue + "%";
        }
        List<Process> processes = processMapper.search_process_by_processId(searchValue);
        return processes;
    }

    /**
     * 通过工艺计划ID模糊查询符合要求的所有工序
     * @param searchValue
     * @return
     */
    @Override
    public List<Process> search_process_by_technologyPlanId(String searchValue) {
        if (null != searchValue) {
            searchValue = "%" + searchValue + "%";
        }
        List<Process> processes = processMapper.search_process_by_technologyPlanId(searchValue);
        return processes;
    }

    @Override
    public List<Process> processGetData() {
        return processMapper.selectAll();
    }

    @Override
    public Process getProcessByProcessId(String processId) {
        return processMapper.getProcessByProcessId(processId);

    }
}
