package com.littlebug.service.impl;

import com.littlebug.bean.Department;
import com.littlebug.dao.DepartmentMapper;
import com.littlebug.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by little Stone
 * Date 2019/4/3 Time 19:34
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public List<Department> queryByDepartmentName(String departmentName) {
        List<Department> departments = departmentMapper.queryByDepartmentName(departmentName);
        return departments;
    }

    @Override
    public List<Department> findAllDepartment() {
        List<Department> departments = departmentMapper.findAllDepartment();
        return departments;
    }

    @Override
    public List<Department> queryByDepartmentId(String id) {
        List<Department> departments = departmentMapper.queryByDepartmentId(id);
        return departments;
    }

    @Override
    public int insert(Department record) {
        int insert = departmentMapper.insert(record);
        return insert ;
    }

    @Override
    public int update(Department department) {
        int update = departmentMapper.update(department);
        return update ;
    }

    @Override
    public int deleteDepartment(String[] ids) {
        return departmentMapper.deleteDepartment(ids);
    }

    @Override
    public Department getDepartmentById(String id) {
        return departmentMapper.getDepartmentById(id);
    }


}
