package com.littlebug.service;

import com.littlebug.bean.Task;

import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/6 4:30
 * @Modified By
 */
public interface TaskService {
    boolean addTask(Task task);

    boolean deleteBatchTasks(String[] ids);

    boolean updateTask(Task task);

    List<Task> showAllTasksByIndexs(int page, int rows);

    int countAllTasks();

    List<Task> selectTasksOnCondition(Task task, int page, int rows);

    int countAllTasksOnCondition(Task task);

    List<Task> showTaskList();

    Task selectTaskByTaskId(String taskId);
}
