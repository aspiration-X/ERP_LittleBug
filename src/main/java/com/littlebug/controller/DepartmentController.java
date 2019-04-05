package com.littlebug.controller;

import com.littlebug.bean.Department;
import com.littlebug.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by little Stone
 * Date 2019/4/3 Time 19:19
 */
@Controller("departmentController")
@RequestMapping("department")

public class DepartmentController {
    @Autowired
    DepartmentService departmentService;



    @RequestMapping("/find")
    public String find(HttpSession httpSession){
        //增删改三个按钮
        List<String> sysPermissonList = (ArrayList<String>) httpSession.getAttribute("sysPermissonList");
        // session 是各个模块共用的，所以可能会覆盖其他模块的sysPermission

        if (sysPermissonList == null){
            sysPermissonList = new ArrayList<>();
        }

        if (!sysPermissonList.contains("department:add")){
            sysPermissonList.add("department:add");
            sysPermissonList.add("department:edit");
            sysPermissonList.add("department:delete");
            httpSession.setAttribute("sysPermissionList", sysPermissonList);
        }

        return "department_list";

    }

    @RequestMapping("/search_department_by_departmentName")
    public @ResponseBody
    List<Department> queryByDepartmentName(String searchValue) {
        List<Department> departments = departmentService.queryByDepartmentName(searchValue);
        return departments;
    }

    @RequestMapping("/list")
    public @ResponseBody
    List<Department> findAllDepartment() {
        List<Department> departments = departmentService.findAllDepartment();
        return departments;
    }

    @RequestMapping("/search_department_by_departmentId")
    public @ResponseBody
    List<Department> queryByDepartmentId(String searchValue) {
        List<Department> departments = departmentService.queryByDepartmentId(searchValue);
        return departments;
    }


//抓包看到响应报文为空的json
    @RequestMapping("/add_judge")
    @ResponseBody
    public void addJudge(){
        return ;
    }

    //显示department_add.jsp
    @RequestMapping("/add")
    public String add(){
        return "department_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, String> insertDepartment(Department department){
        int b = departmentService.insert(department);
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        if (b != 1){
            map.put("msg", "添加异常");
        }
        return map;
    }


    //抓包看到响应报文为空的json
    @RequestMapping("/edit_judge")
    @ResponseBody
    public void editJudge(){
        return;
    }

    //显示department_edit.jsp
    @RequestMapping("/edit")
    public String edit(){
        return "department_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map<String, String> updateAll(Department department){
        int update = departmentService.update(department);
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        if (update != 1){
            map.put("msg", "编辑异常");
        }
        return map;
    }


    //删除部门

    @RequestMapping("/delete_judge")
    @ResponseBody
    public void deleteJudge(){
        return;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids){
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        int i = departmentService.deleteDepartment(ids);

        if (i != ids.length){
            map.put("msg", "删除异常");
        }
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Department> getDepartmentData() {
        List<Department> departments = departmentService.findAllDepartment();
        return departments;
    }



}
