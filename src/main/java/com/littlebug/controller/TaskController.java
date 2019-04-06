package com.littlebug.controller;

import com.littlebug.bean.Task;
import com.littlebug.bean.Task;
import com.littlebug.service.TaskService;
import com.littlebug.util.PageWraper;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/6 4:29
 * @Modified By
 */

@Controller
public class TaskController {


    @Autowired
    TaskService taskService;
    
    @RequestMapping("task/list")
    @ResponseBody
    public PageWraper<Task> findTaskByPage(@RequestParam("page") int page,
                                                  @RequestParam("rows") int rows) {
        PageWraper<Task> pageWraper = new PageWraper<>();
        List<Task> taskList = taskService.showAllTasksByIndexs(page, rows);
        int taskAmount = taskService.countAllTasks();

        pageWraper.setRows(taskList);
        pageWraper.setTotal(taskAmount);
        return pageWraper;
    }


    @RequestMapping("task/insert")
    @ResponseBody
    public UserMessage addProduct(Task task) {
        boolean addTask = taskService.addTask(task);
        UserMessage userMessage = new UserMessage();
        if (addTask){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }



    @RequestMapping(value = "task/delete_batch",
            method= RequestMethod.POST,
            consumes="application/x-www-form-urlencoded")
    @ResponseBody
    public UserMessage deleteBatchTasks(String[] ids) {
        boolean deleteBatchTasks = taskService.deleteBatchTasks(ids);
        UserMessage userMessage = new UserMessage();
        if (deleteBatchTasks){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }


    @RequestMapping("task/update_all")
    @ResponseBody
    public UserMessage updateTask(Task task) {


        boolean updateTask = taskService.updateTask(task);
        UserMessage userMessage = new UserMessage();
        if (updateTask){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;

    }


    /************************ 以下3个方法可以使用正则表达式优化 **************************** */

    @RequestMapping("task/search_Task_by_TaskSn")
    @ResponseBody
    public PageWraper<Task> searchTaskByTaskId(Task task,
                                               @RequestParam("page") int page,
                                               @RequestParam("rows") int rows) {
        PageWraper<Task> pageWraper = new PageWraper<>();
        List<Task> taskList = taskService.selectTasksOnCondition(task, page, rows);
        int TasksAmount = taskService.countAllTasksOnCondition(task);
        pageWraper.setRows(taskList);
        pageWraper.setTotal(TasksAmount);
        return pageWraper;

    }

    @RequestMapping("task/search_Task_by_TaskOrderId")
    @ResponseBody
    public PageWraper<Task> searchTaskByTaskProduct(Task task,
                                                    @RequestParam("page") int page,
                                                    @RequestParam("rows") int rows) {
        PageWraper<Task> pageWraper = new PageWraper<>();
        List<Task> taskList = taskService.selectTasksOnCondition(task, page, rows);
        int TasksAmount = taskService.countAllTasksOnCondition(task);
        pageWraper.setRows(taskList);
        pageWraper.setTotal(TasksAmount);
        return pageWraper;

    }

    @RequestMapping("task/search_Task_by_TaskTechnologyName")
    @ResponseBody
    public PageWraper<Task> searchTaskByTaskDevice(Task task,
                                                   @RequestParam("page") int page,
                                                   @RequestParam("rows") int rows) {
        PageWraper<Task> pageWraper = new PageWraper<>();
        List<Task> TaskList = taskService.selectTasksOnCondition(task, page, rows);
        int TasksAmount = taskService.countAllTasksOnCondition(task);
        pageWraper.setRows(TaskList);
        pageWraper.setTotal(TasksAmount);
        return pageWraper;

    }




    @RequestMapping("task/search_Task_by_TaskProcess")
    @ResponseBody
    public PageWraper<Task> searchTaskByTaskProcess(Task task,
                                                    @RequestParam("page") int page,
                                                    @RequestParam("rows") int rows) {
        PageWraper<Task> pageWraper = new PageWraper<>();
        List<Task> taskList = taskService.selectTasksOnCondition(task, page, rows);
        int TasksAmount = taskService.countAllTasksOnCondition(task);
        pageWraper.setRows(taskList);
        pageWraper.setTotal(TasksAmount);
        return pageWraper;

    }


    @ResponseBody
    @RequestMapping("task/get_data")
    public List<Task> getTaskData() {
        List<Task> taskList = taskService.showTaskList();

        return taskList;
    }

    @ResponseBody
    @RequestMapping("task/get/{taskId}")
    public Task selectTaskByTaskId(@PathVariable("taskId") String taskId) {
        return taskService.selectTaskByTaskId(taskId);
    }


}
