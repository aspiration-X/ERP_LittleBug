package com.littlebug.controller;


import com.littlebug.bean.Technology;
import com.littlebug.service.TechnologyService;
import com.littlebug.util.DuplicatedCodeUtil;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/3 Time 20:19
 */
@Controller
@RequestMapping("technology")
public class TechnologyController {
   @Autowired
   TechnologyService technologyService;

   /**
    * 跳转到工艺分页显示页面
    * @return
    */
   @RequestMapping("find")
    public String find(){
      return "technology_list";
   }

   /**
    * 获取所有工艺
    * @return
    */
   @ResponseBody
   @RequestMapping("list")
   public List<Technology> findAllTechnologies(){
      List<Technology> technologyList = technologyService.findAllTechnologies();
      return technologyList;
   }

   /**
    * 跳转到新增工艺页面,新增工艺
    * @return
    */
   @RequestMapping("add")
   public String add(){
      return "technology_add";
   }
   @RequestMapping("insert")
   @ResponseBody
   public UserMessage insertTechnology(Technology technology){
      boolean flag = technologyService.insertTechnology(technology);
      return DuplicatedCodeUtil.consequenceMessageReturn(flag);
   }

   /**
    * 修改工艺
    * @return
    */
   @RequestMapping("edit")
   public String edit(){
      return "technology_edit";
   }
   @RequestMapping("update_all")
   @ResponseBody
   public UserMessage update_all(Technology technology){
      boolean flag = technologyService.update_all(technology);
      return DuplicatedCodeUtil.consequenceMessageReturn(flag);
   }

   /**
    * 删除一项或几项工艺
    * @return
    */
   @RequestMapping("delete_batch")
   @ResponseBody
   public UserMessage delete_batch(String ids) {
      String[] technologyIds = ids.split(",");
      boolean flag = technologyService.delete_batch(technologyIds);
      return DuplicatedCodeUtil.consequenceMessageReturn(flag);
   }

   /**
    * 通过工艺id模糊查询符合要求的所有工艺
    * @param searchValue
    * @return
    */
   @RequestMapping("search_technology_by_technologyId")
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
   @RequestMapping("search_technology_by_technologyName")
   @ResponseBody
   public List<Technology> search_technology_by_technologyName(String searchValue) {
      List<Technology> technologyList = technologyService.search_technology_by_technologyName(searchValue);
      return technologyList;
   }

}
