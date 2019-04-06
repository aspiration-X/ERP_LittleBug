package com.littlebug.service;

import com.littlebug.bean.Department;

import java.util.List;

/**
 * Created by little Stone
 * Date 2019/4/3 Time 19:27
 */
public interface DepartmentService {

    List<Department> queryByDepartmentName(String departmentName);

    List<Department> findAllDepartment();

    List<Department> queryByDepartmentId(String id);

    int insert(Department record);

    int update(Department department);

    int deleteDepartment(String[] ids);

    Department getDepartmentById(String id);
}
