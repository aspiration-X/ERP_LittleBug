package com.littlebug.controller;

import com.littlebug.bean.*;
import com.littlebug.service.PlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/3 17:15
 * @Modified By
 */
@Controller
public class PlanController {

    @Autowired
    PlanService planService;

/*------------------------------------------------ order ---------------------------------------------------*/
    @RequestMapping("order/list")
    @ResponseBody
    public List<COrder> findByPage(@Param("page") int page, @Param("rows") int rows, HttpServletRequest request) {
        int start = (page - 1) * rows;
        int end = start + rows;
        List<COrder> orderList = planService.showAllOrdersByIndexs(start, end);
        int allRecords = orderList.size();
        int pages = allRecords / rows;
        return orderList;
    }

    @RequestMapping("order/find")
    public String turn() {
        return "order_list";
    }

    @RequestMapping("order/delete_judge")
    public boolean deleteJudge(String[] ids){
        boolean result = planService.deleteJudge(ids);
        return result;
    }

    @RequestMapping("order/delete_batch")
    @ResponseBody
    public void deleteOrderByIds(@Param("ids") String[] ids) {
        planService.deleteBatchOrders(ids);
    }

    @RequestMapping("order/edit_judge")
    @ResponseBody
    public String edit_judge(){
//        return "redirect:order/edit";
        return "{}";
    }

    @RequestMapping("order/add_judge")
    @ResponseBody
    public String add_judge(){
        return "{}";
    }

   @RequestMapping("order/edit")
   public String goEditOrderPage(){
       return "order_edit";
   }


    @RequestMapping("order/add")
    public String goAddOrderPage(){
        return "order_add";
    }

    @RequestMapping("order/update_all")
    public void edit(COrder order){
        planService.updateOrder(order);
    }

    @RequestMapping("order/insert")
    public void addOrder(COrder order){
        planService.addOrder(order);
    }





    /*----------------------------------------------------- product ---------------------------------------------*/


    @ResponseBody
    @RequestMapping("product/get_data")
    public List<Product> getProductData(){
        List<Product> productList = planService.showProductList();

        return productList;
    }

    @ResponseBody
    @RequestMapping("product/get")
    public List<Product> getProductInfoById(){
        List<Product> productList = planService.showProductList();

        return productList;
    }







    /*------------------------------------------------------- custom -------------------------------------------*/

    @ResponseBody
    @RequestMapping("custom/get_data")
    public List<Custom> getCustomData(){
        List<Custom> customList = planService.showCustomList();
        return customList;
    }















    @RequestMapping("custom/list")
    @ResponseBody
    public List<Custom> showCustomList() {
        ArrayList<Custom> list = new ArrayList<>();


        return list;
    }

    @RequestMapping("product/list")
    @ResponseBody
    public List<Product> showProductList() {
        ArrayList<Product> list = new ArrayList<>();


        return list;
    }

    @RequestMapping("work/list")
    @ResponseBody
    public List<Work> showWorkList() {
        ArrayList<Work> list = new ArrayList<>();


        return list;
    }


    @RequestMapping("manufacture/list")
    @ResponseBody
    public List<Manufacture> showManufactureList() {
        ArrayList<Manufacture> list = new ArrayList<>();


        return list;
    }


    @RequestMapping("task/list")
    @ResponseBody
    public List<Task> showTaskList() {
        ArrayList<Task> list = new ArrayList<>();


        return list;
    }
}
