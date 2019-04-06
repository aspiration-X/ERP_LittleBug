package com.littlebug.service.impl;

import com.littlebug.bean.Task;
import com.littlebug.bean.Work;
import com.littlebug.dao.ManufactureMapper;
import com.littlebug.dao.TaskMapper;
import com.littlebug.dao.WorkMapper;
import com.littlebug.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/6 4:30
 * @Modified By
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    WorkMapper workMapper;

    @Autowired
    ManufactureMapper manufactureMapper;


    @Override
    public boolean addTask(Task task) {
        return taskMapper.insert(task) == 1;
    }

    @Override
    public boolean deleteBatchTasks(String[] ids) {
        for (String id :ids
                ) {
            int deleteByPrimaryKey = taskMapper.deleteByPrimaryKey(id);
            if (deleteByPrimaryKey != 1){
                return false;            }
        }
        return true;
    }

    @Override
    public boolean updateTask(Task task) {
        return taskMapper.updateByPrimaryKey(task) == 1;
    }

    @Override
    public Task selectTaskByTaskId(String taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public List<Task> showAllTasksByIndexs(int page, int rows) {

        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }

        return taskMapper.showAllTasksByIndexs(offset, limit);
    }

    @Override
    public int countAllTasks() {
        return taskMapper.countAllTasks();
    }

    @Override
    public List<Task> selectTasksOnCondition(Task task, int page, int rows) {
        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }
        return taskMapper.selectTasksOnCondition(task, offset, limit);
    }

    @Override
    public int countAllTasksOnCondition(Task task) {
        return taskMapper.countAllTasksOnCondition(task);
    }

    @Override
    public List<Task> showTaskList() {
        return taskMapper.showAllTaskList();
    }
}
