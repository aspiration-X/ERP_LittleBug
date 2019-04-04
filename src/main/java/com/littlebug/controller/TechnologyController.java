package com.littlebug.controller;


import com.littlebug.bean.Technology;
import com.littlebug.service.TechnologyService;
import com.littlebug.util.TransferString;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
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
   @RequestMapping("add_judge")
   @ResponseBody
   public String add_judge(){
      return "{}";
   }
   @RequestMapping("add")
   public String add(){
      return "technology_add";
   }
   @RequestMapping("insert")
   @ResponseBody
   public HashMap insertTechnology(Technology technology){
      HashMap<String,String> data = new HashMap<>();
      boolean flag = technologyService.insertTechnology(technology);
      if(flag){
         data.put("status","200");
         data.put("msg","OK");
      }else {
         data.put("status","404");
         data.put("msg","插入失败");
      }
      return data;
   }

   /**
    * 修改工艺
    * @return
    */
   @RequestMapping("edit_judge")
   @ResponseBody
   public String edit_judge(){
      return "{}";
   }
   @RequestMapping("edit")
   public String edit(){
      return "technology_edit";
   }
   @RequestMapping("update_all")
   @ResponseBody
   public UserMessage update_all(Technology technology){
      UserMessage userMessage = new UserMessage();
      boolean flag = technologyService.update_all(technology);
      if(flag){
         userMessage.setStatus(200);
         userMessage.setMsg("OK");
      }else {
         userMessage.setStatus(500);
         userMessage.setMsg("修改失败");
      }
      return userMessage;
   }

   /**
    * 删除一项或几项工艺
    * @return
    */
   @RequestMapping("delete_judge")
   @ResponseBody
   public String delete_judge(){
      return "{}";
   }
   @RequestMapping("delete_batch")
   @ResponseBody
   public UserMessage delete_batch(String ids) {
      List<String> technologyIds = TransferString.transferString(ids);
      UserMessage userMessage = new UserMessage();
      boolean flag = technologyService.delete_batch(technologyIds);
      if(flag){
         userMessage.setStatus(200);
         userMessage.setMsg("OK");
      }else {
         userMessage.setStatus(500);
         userMessage.setMsg("删除失败");
      }
      return userMessage;
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
