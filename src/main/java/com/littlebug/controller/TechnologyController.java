package com.littlebug.controller;


import com.littlebug.bean.Technology;
import com.littlebug.bean.TechnologyPlan;
import com.littlebug.service.TechnologyService;
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
 * Date 2019/4/3 Time 20:19
 */
@Controller
public class TechnologyController {
   @Autowired
   TechnologyService technologyService;

   /**
    * 跳转到工艺分页显示页面
    * @return
    */
   @RequestMapping("technology/find")
    public String technologyFind(){
      return "technology_list";
   }

   /**
    * 获取所有工艺
    * @return
    */
   @ResponseBody
   @RequestMapping("technology/list")
   public List<Technology> findAllTechnologies(){
      List<Technology> technologyList = technologyService.findAllTechnologies();
      return technologyList;
   }

   /**
    * 通过工艺ID获取工艺详情
    * @return
    */
   @RequestMapping("technology/get/{technologyId}")
   @ResponseBody
   public Technology GetTechnologyByTechnologyId(@PathVariable("technologyId")String technologyId){
      Technology technology = technologyService.GetTechnologyByTechnologyId(technologyId);
      return technology;
   }

   /**
    * 新增工艺要求和工艺计划时下拉框需要的工艺信息集合
    * @return
    */
   @RequestMapping("technology/get_data")
   @ResponseBody
   public List<Technology> get_dataTechnology(){
      List<Technology> technologyList = technologyService.findAllTechnologies();
      return technologyList;
   }

   /**
    * 跳转到新增工艺页面,新增工艺
    * @return
    */
   @RequestMapping("technology/add")
   public String technologyAdd(){
      return "technology_add";
   }
   @RequestMapping("technology/insert")
   @ResponseBody
   public UserMessage insertTechnology(Technology technology){
      boolean flag = technologyService.insertTechnology(technology);
      return DuplicatedCodeUtil.consequenceMessageReturn(flag);
   }

   /**
    * 修改工艺
    * @return
    */
   @RequestMapping("technology/edit")
   public String technologyEdit(){
      return "technology_edit";
   }
   @RequestMapping("technology/update_all")
   @ResponseBody
   public UserMessage update_allTechnology(Technology technology){
      boolean flag = technologyService.update_allTechnology(technology);
      return DuplicatedCodeUtil.consequenceMessageReturn(flag);
   }

   /**
    * 删除一项或几项工艺
    * @return
    */
   @RequestMapping("technology/delete_batch")
   @ResponseBody
   public UserMessage delete_batchTechnology(String ids) {
      String[] technologyIds = ids.split(",");
      boolean flag = technologyService.delete_batchTechnology(technologyIds);
      return DuplicatedCodeUtil.consequenceMessageReturn(flag);
   }

   /**
    * 通过工艺id模糊查询符合要求的所有工艺
    * @param searchValue
    * @return
    */
   @RequestMapping("technology/search_technology_by_technologyId")
   @ResponseBody
   public List<Technology> search_technology_by_technologyId(String searchValue) {
      List<Technology> technologyList = technologyService.search_technology_by_technologyId(searchValue);
      return technologyList;
   }

   /**
    * 通过工艺名称模糊查询符合要求的所有工艺
    * @param searchValue
    * @return
    */
   @RequestMapping("technology/search_technology_by_technologyName")
   @ResponseBody
   public List<Technology> search_technology_by_technologyName(String searchValue) {
      List<Technology> technologyList = technologyService.search_technology_by_technologyName(searchValue);
      return technologyList;
   }



//-----------------------------------下面是TechnologyPlan的内容-------------------------------------------//




   /**
    * 跳转到工艺计划分页显示页面
    * @return
    */
   @RequestMapping("technologyPlan/find")
   public String technologyPlanFind(){
      return "technologyPlan_list";
   }

   /**
    * 获取所有工艺计划
    * @return
    */
   @ResponseBody
   @RequestMapping("technologyPlan/list")
   public List<TechnologyPlan> findAllTechnologyPlans(){
      List<TechnologyPlan> technologyPlanList = technologyService.findAllTechnologyPlans();
      return technologyPlanList;
   }

   /**
    * 跳转到新增工艺计划页面,新增工艺计划
    * @return
    */
   @RequestMapping("technologyPlan/add")
   public String technologyPlanAdd(){
      return "technologyPlan_add";
   }
   @RequestMapping("technologyPlan/insert")
   @ResponseBody
   public UserMessage insertTechnologyPlan(TechnologyPlan technologyPlan){
      boolean flag = technologyService.insertTechnologyPlan(technologyPlan);
      return DuplicatedCodeUtil.consequenceMessageReturn(flag);
   }

   /**
    * 跳到修改工艺计划页面，修改公益计划
    * @return
    */
   @RequestMapping("technologyPlan/edit")
   public String technologyPlanEdit(){
      return "technologyPlan_edit";
   }
   @RequestMapping("technologyPlan/update_all")
   @ResponseBody
   public UserMessage update_allTechnologyPlan(TechnologyPlan technologyPlan){
      boolean flag = technologyService.update_allTechnologyPlan(technologyPlan);
      return DuplicatedCodeUtil.consequenceMessageReturn(flag);
   }

   /**
    * 删除一项或几项工艺计划
    * @return
    */
   @RequestMapping("technologyPlan/delete_batch")
   @ResponseBody
   public UserMessage delete_batchTechnologyPlan(String ids) {
      String[] technologyPlanIds = ids.split(",");
      boolean flag = technologyService.delete_batchTechnologyPlan(technologyPlanIds);
      return DuplicatedCodeUtil.consequenceMessageReturn(flag);
   }

   /**
    * 通过工艺计划编号模糊查询符合要求的所有工艺计划
    * @param searchValue
    * @return
    */
   @RequestMapping("technologyPlan/search_technologyPlan_by_technologyPlanId")
   @ResponseBody
   public List<TechnologyPlan> search_technologyPlan_by_technologyPlanId(String searchValue){
      List<TechnologyPlan> TechnologyPlans = technologyService.search_technologyPlan_by_technologyPlanId(searchValue);
      return TechnologyPlans;
   }

   /**
    * 通过工艺名称模糊查询符合要求的所有工艺计划
    * @param searchValue
    * @return
    */
   @RequestMapping("technologyPlan/search_technologyPlan_by_technologyName")
   @ResponseBody
   public List<TechnologyPlan> search_technologyPlan_by_technologyName(String searchValue){
      List<TechnologyPlan> TechnologyPlans = technologyService.search_technologyPlan_by_technologyName(searchValue);
      return TechnologyPlans;
   }

}
