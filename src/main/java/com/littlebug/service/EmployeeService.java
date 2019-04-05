package com.littlebug.service;

import com.littlebug.bean.Employee;

import java.util.List;

/**
 * Created by little Stone
 * Date 2019/4/3 Time 19:28
 */
public interface EmployeeService {

    List<Employee> findAllEmployee();

    List<Employee> findEmployeeList();

    int insertEmployee(Employee employee, String departmentId);

    int updateByPrimaryKey(Employee employee);

    int deleteEmployee(String[] ids);

    List<Employee>  queryByEmployeeId(String empId);
}
