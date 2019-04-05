package com.littlebug.service.impl;

import com.littlebug.bean.Employee;
import com.littlebug.dao.EmployeeMapper;
import com.littlebug.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by little Stone
 * Date 2019/4/3 Time 19:29
 */
@Service("employService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employees = employeeMapper.findAllEmployee();
        return employees;
    }

    @Override
    public int insertEmployee(Employee employee, String departmentId) {
        return employeeMapper.insertEmployee(employee, departmentId);
    }

    @Override
    public int updateByPrimaryKey(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public int deleteEmployee(String[] ids) {
        return employeeMapper.deleteEmployee(ids);
    }

    @Override
    public List<Employee> queryByEmployeeId(String empId) {
        return employeeMapper.queryByEmployeeId(empId);
    }


}
