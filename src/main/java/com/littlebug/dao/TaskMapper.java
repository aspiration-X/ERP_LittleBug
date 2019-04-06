package com.littlebug.dao;

import com.littlebug.bean.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);



    int countAllTasks();

    List<Task> showAllTasksByIndexs(@Param("offset") int offset,@Param("limit") int limit);

    List<Task> selectTasksOnCondition(@Param("task") Task task,
                                      @Param("offset") int offset,
                                      @Param("limit") int limit);

    int countAllTasksOnCondition(@Param("task") Task task);

    List<Task> showAllTaskList();
}