package com.littlebug.dao;

import com.littlebug.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    List<Department> queryByDepartmentName(String departmentName);

    List<Department> findAllDepartment();

    List<Department> queryByDepartmentId(String id);

    Department getDepartmentById(String departmentId);

    int insert(Department record);

    int update(Department department);

    int deleteDepartment(String[] ids);

    int deleteByPrimaryKey(String departmentId);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}