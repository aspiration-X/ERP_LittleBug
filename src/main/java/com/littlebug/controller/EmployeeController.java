package com.littlebug.controller;

import com.littlebug.bean.Employee;
import com.littlebug.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by little Stone
 * Date 2019/4/3 Time 19:26
 */
@Controller("employeeController")
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/find")
    public String find(HttpSession httpSession){
        //增删改三个按钮
        List<String> sysPermissonList = (ArrayList<String>) httpSession.getAttribute("sysPermissonList");
        // session 是各个模块共用的，所以可能会覆盖其他模块的sysPermission

        if (sysPermissonList == null){
            sysPermissonList = new ArrayList<>();
        }

        if (!sysPermissonList.contains("employee:add")){
            sysPermissonList.add("employee:add");
            sysPermissonList.add("employee:edit");
            sysPermissonList.add("employee:delete");
            httpSession.setAttribute("sysPermissionList", sysPermissonList);
        }

        return "employee_list";

    }
    @RequestMapping("/list")
    public @ResponseBody
    List<Employee> findAllEmployee() {
        List<Employee> employees = employeeService.findAllEmployee();
        return employees;
    }

}
