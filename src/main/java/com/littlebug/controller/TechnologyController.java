package com.littlebug.controller;


import com.littlebug.bean.Technology;
import com.littlebug.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
      return "technology_edit";
   }
   @RequestMapping("edit")
   public String edit(){
      return "technology_edit";
   }



}
