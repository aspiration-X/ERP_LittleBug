package com.cskaoyan.dao;

import com.littlebug.bean.Department;
import com.littlebug.bean.Employee;
import com.littlebug.controller.DepartmentController;
import com.littlebug.dao.DepartmentMapper;
import com.littlebug.dao.EmployeeMapper;
import com.littlebug.service.DepartmentService;
import com.littlebug.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by little Stone
 * Date 2019/4/4 Time 9:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class LiTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;
   /* @Autowired
    DepartmentController departmentController;*/
    @Test
    public void myTest1(){
        List<Department> departments = departmentMapper.findAllDepartment();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    @Test
    public void myTest2(){
        List<Department> departments = departmentMapper.queryByDepartmentId("001");
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    @Test
    public void myTest3(){
        List<Department> departments = departmentService.queryByDepartmentId("001");
        for (Department department : departments) {
            System.out.println(department);
        }
    }
    @Test
    public void myTest4(){
        List<Employee> employees = employeeService.findAllEmployee();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    @Test
    public void myTest5(){
        Department department = new Department();
        department.setDepartmentId("123");
        department.setDepartmentName("王道");
        department.setNote("11231");

        int insert = departmentService.insert(department);
    }

}
