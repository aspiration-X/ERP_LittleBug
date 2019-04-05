package com.littlebug.controller;

import com.littlebug.bean.Technology;
import com.littlebug.bean.TechnologyRequirement;
import com.littlebug.service.TechnologyRequirementService;
import com.littlebug.util.DuplicatedCodeUtil;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<TechnologyRequirement> findAllTechnologies(int page,int rows){
        List<TechnologyRequirement> technologyList = technologyRequirementService.findAllTechnologyRequirements(page,rows);
        return technologyList;
    }

    /**
    * 新增插入一个工艺要求
    * @return
    */
    @RequestMapping("add")
    public String add(){
       return "technologyRequirement_add";
    }
    @RequestMapping("insert")
    @ResponseBody
    public UserMessage insert(TechnologyRequirement technologyRequirement){
         boolean flag = technologyRequirementService.insertTechnologyRequirement(technologyRequirement);
         return DuplicatedCodeUtil.consequenceMessageReturn(flag);
     }

    /**
     * 编辑修改一个工艺要求
     * @return
     */
    @RequestMapping("edit")
    public String edit(){
        return "technologyRequirement_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public UserMessage update_all(TechnologyRequirement technologyRequirement){
        boolean flag = technologyRequirementService.update_all(technologyRequirement);
        return DuplicatedCodeUtil.consequenceMessageReturn(flag);
    }

    /**
     * 删除一个或多个工艺要求
     * @param ids
     * @return
     */
    @RequestMapping("delete_batch")
    @ResponseBody
    public UserMessage delete_batch( String ids){
        String[] split = ids.split(",");
        boolean flag = technologyRequirementService.delete_batch(split);
        return DuplicatedCodeUtil.consequenceMessageReturn(flag);
    }

    /**
     * 通过工艺要求编号模糊查询符合要求的所有工艺要求
     * @param searchValue
     * @return
     */
    @RequestMapping("search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public List<TechnologyRequirement> search_technologyRequirement_by_technologyRequirementId(String searchValue){
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.search_technologyRequirement_by_technologyRequirementId(searchValue);
        return technologyRequirements;
    }

    /**
     * 通过工艺名称模糊查询符合要求的所有工艺要求
     * @param searchValue
     * @return
     */
    @RequestMapping("search_technologyRequirement_by_technologyName")
    @ResponseBody
    public List<TechnologyRequirement> search_technologyRequirement_by_technologyName(String searchValue){
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.search_technologyRequirement_by_technologyName(searchValue);
        return technologyRequirements;
    }
}
