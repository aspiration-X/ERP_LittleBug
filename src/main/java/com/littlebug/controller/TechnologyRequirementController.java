package com.littlebug.controller;

import com.littlebug.bean.TechnologyRequirement;
import com.littlebug.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/5 Time 0:19
 */
@Controller
@RequestMapping("technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementService technologyRequirementService;
    /**
     * 跳转到工艺要求分页显示页面
     * @return
     */
    @RequestMapping("find")
    public String find(){
        return "technologyRequirement_list";
    }

    /**
     * 获取所有工艺要求
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public List<TechnologyRequirement> findAllTechnologies(){
        List<TechnologyRequirement> technologyList = technologyRequirementService.findAllTechnologyRequirements();
        return technologyList;
    }

}
