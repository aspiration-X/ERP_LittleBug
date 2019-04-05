package com.littlebug.controller;

import com.littlebug.bean.Process;
import com.littlebug.service.ProcessService;
import com.littlebug.util.DuplicatedCodeUtil;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/5 Time 22:49
 */
@Controller
public class ProcessController {
    @Autowired
    ProcessService processService;

    /**
     * 跳转到工序管理显示页面
     * @return
     */
    @RequestMapping("process/find")
    public String processFind(){
        return "process_list";
    }

    /**
     * 获取所有工序
     * @return
     */
    @ResponseBody
    @RequestMapping("process/list")
    public List<Process> findAllProcesses(){
        List<Process> processList = processService.findAllProcesses();
        return processList;
    }


    /**
     * 跳转到新增工序页面,新增工序
     * @return
     */
    @RequestMapping("process/add")
    public String processAdd(){
        return "process_add";
    }
    @RequestMapping("process/insert")
    @ResponseBody
    public UserMessage insertProcess(Process process){
        boolean flag = processService.insertProcess(process);
        return DuplicatedCodeUtil.consequenceMessageReturn(flag);
    }

    /**
     * 修改工序
     * @return
     */
    @RequestMapping("process/edit")
    public String processEdit(){
        return "process_edit";
    }
    @RequestMapping("process/update_all")
    @ResponseBody
    public UserMessage update_allProcess(Process process){
        boolean flag = processService.update_allProcess(process);
        return DuplicatedCodeUtil.consequenceMessageReturn(flag);
    }

    /**
     * 删除一项或几项工序
     * @return
     */
    @RequestMapping("process/delete_batch")
    @ResponseBody
    public UserMessage delete_batchProcess(String ids) {
        String[] processIds = ids.split(",");
        boolean flag = processService.delete_batchProcess(processIds);
        return DuplicatedCodeUtil.consequenceMessageReturn(flag);
    }

    /**
     * 通过工序id模糊查询符合要求的所有工序
     * @param searchValue
     * @return
     */
    @RequestMapping("process/search_process_by_processId")
    @ResponseBody
    public List<Process> search_process_by_processId(String searchValue) {
        List<Process> processList = processService.search_process_by_processId(searchValue);
        return processList;
    }

    /**
     * 通过工艺计划ID模糊查询符合要求的所有工序
     * @param searchValue
     * @return
     */
    @RequestMapping("process/search_process_by_technologyName")
    @ResponseBody
    public List<Process> search_process_by_technologyPlanId(String searchValue) {
        List<Process> processList = processService.search_process_by_technologyPlanId(searchValue);
        return processList;
    }

}
